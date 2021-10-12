#include <bits/stdc++.h>

using namespace std;

vector<pair<int,int> > v[5001];

int bfs(int start,int k){
	int ret = 0;
	queue<pair<int,int> > q;
	bool visited[5001];
	
	fill(visited, visited+5001, false);
	q.push({start,1e9});
	visited[start] = true;
	
	while(!q.empty()){
		int cur = q.front().first;
		int cost = q.front().second;
		if(cost >= k) ret++;
		q.pop();
		
		for(int i=0; i<v[cur].size(); i++){
			int next = v[cur][i].first;
			int nCost = v[cur][i].second;
			if(!visited[next]){
				visited[next] = true;
				if(cost < nCost){
					q.push({next,cost});
				}else{
					q.push({next,nCost});
				}
			}
		}
		
	}
	
	return ret-1;
	
}

int main(){
	int N,Q;
	cin >> N >> Q;
	for(int i=0; i<N-1; i++){
		int p,q,r;
		cin >> p >> q >> r;
		v[p].push_back({q,r});
		v[q].push_back({p,r});
	}
	
	while(Q--){
		int k,V;
		cin >> k >> V;
		cout << bfs(V,k)<< endl;
	}
	return 0;
}
