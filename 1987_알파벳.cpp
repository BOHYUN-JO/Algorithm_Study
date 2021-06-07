#include <iostream>
#include <vector>

using namespace std;

char arr[21][21];
int visit[21][21] = {0,};
int px[4] ={0,0,-1,1};
int py[4] = {1,-1,0,0};
int r,c, tmax = 0;
vector<char> v;

bool check(int x, int y){
	for(int i=0; i<v.size(); i++){
		if(arr[y][x] == v[i]){
			return false;
		}
	}
	return true;
}

void dfs(int x, int y){
		
	for(int i=0; i<4; i++){
		int nx = x + px[i];
		int ny = y + py[i];
		if(nx < 0 || ny < 0 || nx >=c || ny >= r )
			continue;
		if(visit[ny][nx] == 0 && check(nx, ny)){
			visit[ny][nx] = 1;
			v.push_back(arr[ny][nx]);
			if(tmax < v.size()){
				tmax = v.size();
			}
			dfs(nx,ny);
			visit[ny][nx] = 0;
			v.pop_back();
		}
			
	}	
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> r >> c;
	for(int i=0; i<r; i++){
		for(int j=0; j<c; j++){
			cin >> arr[i][j];
		}
	}
	visit[0][0] = 1;
	v.push_back(arr[0][0]);
	if(tmax < v.size()){
		tmax = v.size();
	}
	dfs(0,0); 
	cout << tmax << endl;
	return 0;
}
