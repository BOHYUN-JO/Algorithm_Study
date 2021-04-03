#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int  N,L,tmp,cnt = 0;
	vector<int> v;
	priority_queue<int, vector<int>, greater<int> > pq;
	cin >> N >> L;
	for(int i=0; i< N; i++){
		cin >> tmp;
		pq.push(tmp);
	}
	
	
	while(!pq.empty()){
		tmp = pq.top();
		pq.pop();
		while(!pq.empty()){
			if(pq.top() <= tmp+L-1){
				pq.pop();
			}else{
				cnt++;
				break;			
			}
		}	
	}
	cnt++;
	
	cout << cnt << endl;
			
}
