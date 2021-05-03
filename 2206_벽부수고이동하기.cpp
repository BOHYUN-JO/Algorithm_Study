#include <iostream>
#include <string>
#include <queue>
#include <utility>

using namespace std;

int main(){
	int n,m,i,j, y,x, ny, nx, cnt=0;
	int mx[4] = {-1,0,1,0};
	int my[4] = {0,-1,0,1};
	int breakCnt = 0, ansFlag = 0;
	char arr[1001][1001];
	short check[1001][1001][2];
	queue<pair<pair<int, int> , int> > q;
	cin >> n >> m;
	for(i=0; i<n; i++){
		for(j=0; j < m ; j++){
			cin >> arr[i][j];
		}
	}	
	
	q.push(make_pair(make_pair(0,0), 1));
	check[0][0][1] = 1;
	while(!q.empty()){
		y = q.front().first.first;
		x = q.front().first.second;
		breakCnt = q.front().second;
		q.pop();
		if(y == n-1 && x == m-1){
			cout << check[y][x][breakCnt] << '\n';
			ansFlag =1;
			break;
		}
		for(i=0; i<4; i++){
			ny = y + my[i];
			nx = x + mx[i];
			if(ny <0 || nx < 0 || nx >=m || ny > n){
				continue;
			}
			if(arr[ny][nx] == '1' && breakCnt){
				check[ny][nx][breakCnt-1] = check[y][x][breakCnt]+1;
				q.push(make_pair(make_pair(ny,nx), breakCnt-1));
			}
			
			if(check[ny][nx][breakCnt] == 0 && arr[ny][nx] == '0'){
				check[ny][nx][breakCnt] = check[y][x][breakCnt] +1;
				q.push(make_pair(make_pair(ny,nx), breakCnt));
			}
				
		}
	}
	
	if(!ansFlag){
		cout << -1 << '\n';
	}
	return 0;
	
}
