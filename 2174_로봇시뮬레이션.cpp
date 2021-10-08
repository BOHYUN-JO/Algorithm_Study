#include <bits/stdc++.h>

using namespace std;

typedef struct{
	int y;
	int x;
	int dir;
}robot;

int arr[101][101] = {0,};

int main(){
	int A,B,N,M;
	vector<robot> v;
	
	int my[4] = {1,0,-1,0};
	int mx[4] = {0,1,0,-1};
	int ldir[4] = {3,0,1,2};
	int rdir[4] = {1,2,3,0};
	map<char,int> m;
	
	m['N'] = 0; m['E'] = 1; m['S'] = 2; m['W'] = 3;
	
	cin >> A >> B >> N >> M;
	
	for(int i=1; i<=N; i++){
		robot tmp;
		char temp;
		cin >> tmp.x >> tmp.y >> temp;
		tmp.dir = m[temp];
		arr[tmp.y][tmp.x] = i;
		v.push_back(tmp);	
	}
	
	for(int i=0; i<M; i++){
		int idx, it;
		char cmd;
		cin >> idx >> cmd >> it;
		for(int j=0; j<it; j++){
			if(cmd == 'L'){
				v[idx-1].dir = ldir[v[idx-1].dir];
			}else if(cmd == 'R'){
				v[idx-1].dir = rdir[v[idx-1].dir];
			}else{
				int ny = v[idx-1].y + my[v[idx-1].dir];
				int nx = v[idx-1].x + mx[v[idx-1].dir];
				if(ny<1 || nx < 1 || ny > B  || nx >A){
					cout << "Robot " << idx << " crashes into the wall"<<endl;
					return 0;
				}
				if(arr[ny][nx] != 0){
					cout << "Robot "<< idx << " crashes into robot " << arr[ny][nx]<< endl;
					return 0;  
				}
				arr[v[idx-1].y][v[idx-1].x] = 0;
				v[idx-1].y = ny;
				v[idx-1].x = nx;
				arr[ny][nx] = idx;
			}
		}
	}
	
	cout << "OK"<<endl;
	
	return 0;
}
