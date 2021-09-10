#include <bits/stdc++.h>

using namespace std;

int N, M;

void bfs(vector<vector<int> >& v, int y, int x){
	queue<pair<int,int> > q;
	int mx[4] = {0,0,-1,1};
	int my[4] = {-1,1,0,0};

	q.push({y,x});
	while(!q.empty()){
		int cur_y = q.front().first;
		int cur_x = q.front().second;
		q.pop();
		
		for(int i=0; i<4; i++){
			int next_y = cur_y + my[i];
			int next_x = cur_x + mx[i];
			if(next_y <0 || next_x <0 || next_y >=N || next_x >=M ) continue;
			if(v[next_y][next_x] == 0){
				v[next_y][next_x] = 2;
				q.push({next_y,next_x});
			}			
		}
	}
	
}

int main(){
	vector<vector<int> > v;
	vector<int> ind;
	vector<pair<int,int> > zero;
	vector<pair<int,int> > two;
	int tmax = 0, cnt=0;
	
	cin >> N >> M;
	for(int i=0; i<N; i++){
		vector<int> temp;
		int tmp;
		for(int j=0; j<M; j++){
			cin >> tmp;
			temp.push_back(tmp);
			if(tmp == 0) zero.push_back({i,j});
			else if(tmp == 2) two.push_back({i,j});
		}
		v.push_back(temp);
	}
	
	for(int i=0; i<3; i++) ind.push_back(1);
	for(int i=0; i<zero.size()-3; i++) ind.push_back(0);
	
	sort(ind.begin(), ind.end());
	
	do{
		vector<vector<int> > tmp = v;
		cnt = 0;
		for(int i=0; i<zero.size(); i++){
			if(ind[i] == 1){
				tmp[zero[i].first][zero[i].second] = 1;
			}
		}
		for(int i=0; i<two.size(); i++){
			bfs(tmp, two[i].first, two[i].second);
		}
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(tmp[i][j] == 0) cnt++;
			}
		}
		if(tmax < cnt){
			tmax = cnt;
		} 
		
	}while(next_permutation(ind.begin(), ind.end()));	
	
	cout << tmax <<endl;
	return 0;
}
