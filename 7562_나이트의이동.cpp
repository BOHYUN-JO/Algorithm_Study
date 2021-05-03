#include <cstdio>
#include <utility>
#include <queue>

using namespace std;

int mx[8] = {-2,-1,1,2,2,1,-1,-2};
int my[8] = {1,2,2,1,-1,-2,-2,-1};

int main(){
	int T,l,x,y,tarx,tary, ny,nx, starty,startx;
	scanf("%d", &T);
	while(T--){
		scanf("%d", &l);
		scanf("%d %d", &y, &x);
		starty = y; startx = x;
		scanf("%d %d", &tary, &tarx);
		if(tary == starty && tarx == startx){
			printf("0\n");
			continue;
		}
		int check[301][301] = {0,};
		int cnt =0;
		pair<int,int> parent[301][301];
		queue< pair<int, int> > q;
		pair<int, int> p;
		q.push(make_pair(y,x));
		check[y][x] = 1;
		while(!q.empty()){
			y = q.front().first;
			x = q.front().second;
			q.pop();
			if(y == tary && x == tarx){
				break;
			}
			for(int i =0; i<8; i++){
				ny = y + my[i];
				nx = x + mx[i];
				if(ny < 0 || nx <0 || ny >= l || nx >= l){
					continue;
				}
				if(check[ny][nx] == 0){
					check[ny][nx] = 1;
					parent[ny][nx] = make_pair(y,x); 
					q.push(make_pair(ny,nx));
				}
			}
		}
		while(1){
			cnt++;
			if(tary == starty && tarx == startx){
				break;
			}
			p = parent[tary][tarx];	
			tary = p.first;
			tarx = p.second;
		}
		printf("%d\n", cnt-1);						
	}
	return 0;
}
