#include <bits/stdc++.h>

using namespace std;

int arr[60][60] = {0,};
bool visited[51][51];
int n,m,tmax=0;


void bfs(int y, int x){
	queue<pair<int,int> > q;
	int dy[4] = {0,-1,0,1};
	int dx[4] = {-1,0,1,0};
	int size = 1;
	
	visited[y][x] = true;
	q.push({y,x});
	while(!q.empty()){
		int cury = q.front().first;
		int curx = q.front().second;
		q.pop();
		
		for(int i=0; i<4; i++){
			int ny = cury + dy[i];
			int nx = curx + dx[i];
			if(ny <0 || nx < 0 || ny>= m || nx >= n) continue;
			
			if(!visited[ny][nx] && (arr[cury][curx] & (1<<i)) == 0  ){
				q.push({ny,nx});
				visited[ny][nx] = true;
				size++;
			}
		}	
	}
	
	if(size > tmax){
		tmax = size;
	}
}


int main(){
	int rCnt=0, maxSize;
	int tmp;
	fill(visited[0], visited[51], false);
	cin >> n >> m;
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			cin >> tmp;
			arr[i][j] = tmp;
		}
	}
	
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			if(!visited[i][j]){
				bfs(i,j);
				rCnt++;
			}
		}
	}
	
	cout << rCnt << '\n' << tmax << endl;
	
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			int prev = arr[i][j];
			for(int k=3; k>=0; k--){
				if(arr[i][j] &(1<<k) !=0 ){
					arr[i][j] ^= (1<<k);
					fill(visited[0],visited[51], false);
					bfs(i,j);
					arr[i][j] = prev;
				}
			}
		}
	}
	
	cout << tmax << endl;



	
	return 0;
}
