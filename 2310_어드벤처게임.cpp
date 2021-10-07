#include <bits/stdc++.h>

using namespace std;

int N;
bool check[1001];
bool ans;
vector<int> adj[1001];
vector<pair<char,int> > room;

void dfs(int start, int money){
	
	if(room[start].first == 'L' && room[start].second > money){
		money = room[start].second;
	}
	if(room[start].first == 'T'){
		if(room[start].second > money){
			return;
		}else{
			money -= room[start].second;
		}
	}
	
	if(start == N){
		ans = true;
		return;
	}
	
	check[start] = true;
	
	for(int i=0; i< adj[start].size(); i++){
		int next = adj[start][i];
		if(!check[next]){
			dfs(next,money);
		}
	}
	check[start] = false;
	
}

int main(){
	
	while(1){
		cin >> N;
		if(N == 0) break;
		for(int i=0; i<1001; i++) adj[i].clear();
		room.clear();
		ans = false;
		room.push_back({'D',0});	// dummy
		for(int i=1; i<=N; i++){
			char ch; int cost;
			cin >> ch >> cost;
			room.push_back({ch,cost});
			while(1){
				int tmp;
				cin >> tmp;
				if(tmp == 0) break;
				adj[i].push_back(tmp);
			}
		}
		fill(check, check+1001, false);
		dfs(1,0);
		if(ans){
			cout << "Yes" << endl;
		}else{
			cout << "No" << endl;
		}
	}	
	
	return 0;
}
