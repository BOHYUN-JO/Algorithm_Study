#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321

using namespace std;

vector<pair<int,int> > post[201];
int dist[201];
int parent[201];

void dijsktra(int x, int n){
	for(int i=1; i <=n ; i++){
		dist[i] = INF;
	}
	priority_queue<pair<int, int> > pq;
	pq.push({0,x});
	dist[x] = 0;
	while(!pq.empty()){
		int cur = pq.top().second;
		int w = pq.top().first;
		pq.pop();
		if(dist[cur] < w )
			continue;
		for(int i=0; i< post[cur].size(); i++){
			int next = post[cur][i].first;
			int next_w = w + post[cur][i].second;
			
			if(dist[next] > next_w){
				parent[next] = cur;
				dist[next] = next_w;
				pq.push({next_w, next});
			}
		}
	}
	
	for(int i=1; i<=n ; i++){
		if(i == x){
			cout << "- ";
		}else if(parent[i] == x){
			cout << i <<" ";
		}else{
			int idx = i;
			while(1){
				if(parent[idx] == x){
					cout << idx <<" ";
					break;
				}else{
					idx = parent[idx];
				}
			}
		}
	}
	cout << '\n';
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n,m,a,b, w;
	cin >> n >> m;
	for(int i=0; i< m; i++){
		cin >> a >> b >> w;
		post[a].push_back({b,w});
		post[b].push_back({a,w});
	}
	
	for(int i= 1; i<=n ; i++){
		dijsktra(i,n);
	}
	
	
	return 0;
}
