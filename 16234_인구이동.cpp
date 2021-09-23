#include <bits/stdc++.h>

using namespace std;

int main(){
	int n,l,r,cnt = 0;
	int arr[51][51];
	int my[4] = {-1,1,0,0};
	int mx[4] = {0,0,-1,1};

	cin >> n >> l >> r;
	
	for(int i=0; i<n ; i++){
		for(int j=0; j<n; j++){
			cin >> arr[i][j];
		}
	}
	bool flag=true;
	while(flag){
		flag = false;
		bool visited[51][51];
		fill(visited[0], visited[51], 0);
		for(int i=0; i<n ; i++){
			for(int j=0; j<n; j++){
				if(visited[i][j]) continue;
				queue<pair<int,int> > q;
				vector<pair<int,int> > v;
				q.push({i,j});
				visited[i][j] = true;
				while(!q.empty()){
					int y = q.front().first;
					int x = q.front().second;
					q.pop();
				
					for(int k=0; k<4; k++){
						int next_y = y + my[k];
						int next_x = x + mx[k];
						if(next_y <0 || next_x < 0 || next_x >=n || next_y >= n) continue;
						int tmp =  abs(arr[next_y][next_x]-arr[y][x]);
						if(!visited[next_y][next_x] && tmp >= l && tmp <=r){
							visited[next_y][next_x] = true;
							q.push({next_y,next_x});
							v.push_back({next_y,next_x});
						}
					}	
				}
			
				if(v.size() > 0){
					flag = true;
					v.push_back({i,j});
					int sum = 0;
					for(int i=0; i<v.size(); i++){
						sum += arr[v[i].first][v[i].second];
					}
					sum /= v.size();
					for(int i=0; i<v.size(); i++){
						arr[v[i].first][v[i].second] = sum;
					}
				}
				v.clear();
			}
		}
		if(!flag) break;
		cnt++;	
	}
	cout << cnt<<endl;
	
	return 0;
}
