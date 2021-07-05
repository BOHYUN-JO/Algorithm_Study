#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> v[1001];
int visited[1001] = {-1,};
int parent[1001] = {-1,};

int bfs(int src, int dst){
	queue<int> q;
	q.push(src);
	visited[src] = 0;
	parent[src] = 0;
	
	while(!q.empty()){
		int a = q.front();
		q.pop();
		if(a == dst){
			break;
		} 
		
		for(int i=0; i< v[a].size(); i++){
			int b = v[a][i];
			if(visited[b] == -1){
				q.push(b);
				parent[b] = a;
				visited[b] = visited[parent[b]] + 1;
			}
		}
	}
	
	return visited[dst];	
}

int main(){
	int N,M;
	int src, dst;
	cin >> src >> dst;
	cin >> N >> M;
	for(int i=0; i<M; i++){
		int a,b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for(int i=0; i<=N; i++){
		visited[i] = -1;
		parent[i] = -1;
	}
	
	
	cout << bfs(src, dst);
		
	return 0;
}
