#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int N,s,t,i;
	vector<pair<int,int> > v;
	priority_queue<int, vector<int>, greater<int> > pq;
	cin >> N;
	for(i =0; i<N ; i++){
		cin >> s >> t;
		v.push_back(make_pair(s,t));
	}
	
	sort(v.begin(), v.end());
	pq.push(v[0].second);
	
	for(i=1; i<N; i++){
		if(pq.top() <= v[i].first){
			pq.pop();
			pq.push(v[i].second);
		}
		else{
			pq.push(v[i].second);
		}
	}

	cout<< pq.size();
	
	return 0;
	
}
