#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int N, i, tmp, total=0, tempSum=0 ;
	cin >> N;
	priority_queue<int, vector<int>, greater<int> > pq;
	
	for(i=0; i<N; i++){
		cin >> tmp;
		pq.push(tmp);
	}
	
	while(!(pq.size() == 1)) {		
		tmp = pq.top();
		pq.pop();
		tempSum = tmp + pq.top();
		pq.pop();
		total += tempSum;
		pq.push(tempSum);
	}
	
	cout << total << endl;
	
	
	return 0;
}
