#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
using namespace std;

int main(){
	int T,i,j;
	cin >> T;
	for(i=0; i<T; i++ ){
		int N, tmp, max=0, start=0, end;
		priority_queue<int, vector<int>, greater<int> > pq; 
		cin >> N;
		end = N-1;
		int* arr = new int[N];
		for(j=0; j<N; j++){
			cin >> tmp;
			pq.push(tmp);
		}
		
		while(!pq.empty()){
			arr[start++] = pq.top();
			pq.pop();
			if(pq.empty())
				break;
			arr[end--] = pq.top();
			pq.pop();
		}
		for(j=0; j<N-1; j++){
			if(abs(arr[j+1]-arr[j]) > max){
				max = abs(arr[j+1]-arr[j]);
			}
		}
		
		cout<< max << endl;
						
	}
}
