#include <bits/stdc++.h>

using namespace std;

int arr[201][201];
int R,C,N;

void fillArr(int cnt){
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			if(arr[i][j] == -1){
				arr[i][j] = cnt;
			}
		}
	}
}

void bomb(int cnt){
	vector<pair<int,int> > v;
	int my[4] = {-1,0,1,0};
	int mx[4] = {0,1,0,-1};
	
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			if(arr[i][j] == cnt-3){
				v.push_back({i,j});
			}
		}
	}
	
	for(int i=0; i<v.size(); i++){
		int y = v[i].first;
		int x = v[i].second;
		arr[y][x] = -1;
		for(int j=0; j<4; j++){
			int ny = y + my[j];
			int nx = x + mx[j];
			if(ny < 0 || nx <0 || ny>=R || nx >=C) continue;
			arr[ny][nx] = -1;
		}	
	}
}

int main(){
	cin >> R >> C >> N;
	int cnt = 0;
	string tmp;
	
	fill(arr[0], arr[201], -1);
	for(int i=0; i<R; i++){
		cin >> tmp;
		for(int j=0; j<tmp.length(); j++){
			if(tmp[j] == 'O'){
				arr[i][j] = 0;
			}
		}
	}
	cnt = 1;
	while(1){
		if(cnt >= N ) break;
		cnt++;
		fillArr(cnt); 
		if(cnt >= N) break;
		cnt++;
		bomb(cnt);
		if(cnt >= N) break;
	}
	
	for(int i=0; i<R; i++){
		for(int j=0; j<C ;j++){
			if(arr[i][j] == -1){
				cout << '.';
			}else cout << 'O';
		}
		cout << endl;
	}
	
	
	return 0;
}
