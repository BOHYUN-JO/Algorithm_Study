#include <bits/stdc++.h>

using namespace std;

typedef struct{
	int y;
	int x;
	int value;
}dust;

int R,C,T;
int arr[51][51];
int my[4] = {-1,1,0,0};
int mx[4] = {0,0,-1,1};
vector<dust> v;
vector<pair<int,int> > cleaner;


void update(){
	v.clear();
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			if( arr[i][j]!=0 && arr[i][j] != -1 ){
				dust tmp;
				tmp.y = i; tmp.x = j; tmp.value = arr[i][j];
				v.push_back(tmp);
			}
		}
	}
}

void expandDust(){
	for(int i=0; i<v.size(); i++){
		int y = v[i].y;
		int x = v[i].x;
		int val = v[i].value;
		int cnt = 0;
		for(int j=0; j<4; j++){
			int ny = y + my[j];
			int nx = x + mx[j];
			if(ny<0 || nx < 0 || ny >= R || nx >=C ) continue;
			if(arr[ny][nx] != -1){
				cnt++;
				arr[ny][nx] += val/5;
			}
		}
		arr[y][x] -= (val/5)*cnt;
	}
	update();
}

void freshAir(){
	int y,x;
	/* À­ÂÊ */
	y= cleaner[0].first;
	x = cleaner[0].second;
	for(int i=y-1; i>0; i-- ){
		arr[i][x] = arr[i-1][x];
	}
	for(int i=0;i<C-1;i++){
		arr[0][i] = arr[0][i+1];
	}
	for(int i=0; i<y; i++){
		arr[i][C-1] = arr[i+1][C-1];
	}
	for(int i=C-1; i>1; i--){
		arr[y][i] = arr[y][i-1];
	}
	arr[y][1] = 0;
	/*¾Æ·§ÂÊ*/
	y = cleaner[1].first;
	x = cleaner[1].second;
	for(int i=y+1; i<R-1; i++ ){
		arr[i][0] = arr[i+1][0];
	}
	for(int i=0; i<C-1; i++){
		arr[R-1][i] = arr[R-1][i+1];
	}
	for(int i=R-1; i>y; i--){
		arr[i][C-1] = arr[i-1][C-1];
	}
	for(int i=C-1; i>1; i--){
		arr[y][i] = arr[y][i-1];
	}
	arr[y][1] = 0;
	update();
}

int main(){
	
	cin >> R >> C >> T;
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			cin >> arr[i][j];
			if(arr[i][j] == -1){
				cleaner.push_back({i,j});
			}else if(arr[i][j] != 0){
				dust tmp;
				tmp.y = i; tmp.x = j; tmp.value = arr[i][j];
				v.push_back(tmp);
			}
		}
	}
	
	while(T--){
		expandDust();
		freshAir();
	}
	int sum = 0;
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			if(arr[i][j] != 0 && arr[i][j] != -1) sum += arr[i][j];
		}
	}
	cout << sum << endl;
	return 0;
}
