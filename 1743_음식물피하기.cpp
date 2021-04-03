#include <iostream>

using namespace std;

int arr[102][102] = {'.',};
int mx[4] = {-1, 0, 0, 1 };
int my[4] = {0, -1, 1, 0 };
int tmp=0;

void dfs(int y, int x, int H, int W ){
	if(arr[y][x] == '#'){
		arr[y][x] = '.';
		tmp++;
		for(int i=0; i<4; i++){
			int new_x = x+mx[i];
			int new_y = y+my[i];
			if(new_y < 0 || new_y > H || new_x <0 || new_x > W)
				continue;
			dfs(new_y, new_x, H, W);
		}
	}
}

int main(){
	int N,M,K,i,j, tmpx, tmpy, max=0;
	cin >> N >> M >> K;
	for(i=0; i<K ; i++){
		cin >> tmpy >> tmpx;
		arr[tmpy][tmpx] = '#';
	}
	
	for(i=1; i<=N ; i++){
		for(j=1; j<=M; j++){
			if(arr[i][j] == '#'){
				tmp=0;
				dfs(i,j, N, M);
				if(tmp >= max){
					max = tmp;
				}
			}
		}
	}
	
	cout << max << endl;
	
	return 0;
}
