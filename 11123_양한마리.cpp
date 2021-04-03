#include <iostream>


using namespace std;

char arr[102][102]= {'.',};
int check[102][102] = {0,}; 
int mx[4] = {-1, 0, 0, 1 };
int my[4] = {0, -1, 1, 0 };

void dfs(int y, int x, int H, int W ){
	if(arr[y][x] == '#'){
		arr[y][x] = '.';
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
	int T,H,W,i,j,cnt =0;
	cin >> T;
	while(T--){
		cnt = 0;
		cin >> H >> W;
		for(i=1; i<=H; i++){
			for(j=1; j<=W; j++){
				cin >> arr[i][j];
			}
		}
	
		for(i=1; i<=H ; i++){
			for(j=1; j<=W; j++){
				if(arr[i][j] == '#'){
					dfs(i,j, H, W);
					cnt++;
				}
			}
		}
		
		for(i=1; i<=H ; i++){
			for(j=1; j<=W; j++){
				arr[i][j] = '.';
			}
		}
		
		
		cout<< cnt << endl;
	}
	
	
	return 0;
}
