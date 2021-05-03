#include <iostream>
 
using namespace std;

int mx[8] = {-1,0,1,-1,1,-1,0,1};
int my[8] = {-1,-1,-1,0,0,1,1,1};
int arr[50][50]= {{0,},};

void dfs(int y, int x, int w, int h){
	int new_x, new_y;
	if(arr[y][x] == 1){
		arr[y][x] = 0;
		for(int i=0; i<8; i++){
			new_x = x + mx[i];
			new_y = y + my[i];
			if(new_x < 0 || new_y < 0 || new_x >=w || new_y >=h){
				continue;
			}
			dfs(new_y, new_x, w, h);
			
		}	
	}
}

int main(){
	int w,h,i,j,cnt=0;
	while(1){
		cin >> w >> h;
		cnt =0;
		if(w==0 && h == 0){
			break;
		}
		for(i=0; i<h; i++){
			for(j=0; j<w; j++){
				cin >> arr[i][j];
			}
		}
		
		for(i=0;i<h; i++){
			for(j=0; j<w; j++){
				if(arr[i][j] == 1){
					dfs(i,j,w,h);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
		
	}
}
