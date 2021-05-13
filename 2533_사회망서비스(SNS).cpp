#include <iostream>
#include <vector>
#include <cstring>

#define endl '\n'

using namespace std;

int memo[1000001][2];
vector<int> v[1000001];
vector<bool> visit;
vector<int> tree[1000001];

int min(int a, int b){
	return a<b ? a : b;
}

void make_tree(int cur){
	visit[cur] = true;
	for(int i=0; i< v[cur].size(); i++){
		int next = v[cur][i];
		if(visit[next] == false){
			tree[cur].push_back(next);
			make_tree(next);
		}
	}
}

int dfs(int cur, int state){
	if(memo[cur][state] != -1){
		return memo[cur][state];
	}
	if(state == 1){
		memo[cur][state] = 1;
		for(int i=0; i< tree[cur].size(); i++){
			int next = tree[cur][i];
			memo[cur][state] += min(dfs(next,0), dfs(next,1));
		}
	}
	else{
		memo[cur][state] = 0;
		for(int i=0; i < tree[cur].size(); i++){
			int next = tree[cur][i];
			memo[cur][state] += dfs(next, 1);
		}
	}
	return memo[cur][state];
}

int main(){
	int N,U,V,i;
		
	
	cin >> N;
	for(i=0; i<N-1 ; i++){
		cin >> U >> V;
		v[U].push_back(V);
		v[V].push_back(U);
	}
	visit.resize(1000001, false);
	
	make_tree(1);
	memset(memo, -1, sizeof(memo));
	int ret1 = dfs(1,0);
	int ret2 = dfs(1,1);
	cout << min(ret1, ret2) << endl;
	
	
		
	return 0;
}
