#include <bits/stdc++.h>

using namespace std;

int main(){
	int N, M, cnt=0;
	int arr[51][51];
	int my[4] = {1,0,-1,0};
	int mx[4] = {0,-1,0,1};
	int cur_x, cur_y, cur_dir;
	cin >> N >> M;
	cin >> cur_y >> cur_x >> cur_dir;
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
			cin >> arr[i][j];
		}
	}
	
	int check = 0;
	int next_y, next_x;
	bool stop_flag = false;
	while(!stop_flag){
		cnt++;
		arr[cur_y][cur_x] = 2;
		check = 0;
		while(1){
			if(cur_dir == 0){
				next_y = cur_y;
				next_x = cur_x -1;
				if(arr[next_y][next_x] == 1 || arr[next_y][next_x] == 2){
					cur_dir = 3;
					check++;
				}else{
					cur_dir = 3;
					cur_x = next_x;
					break;
				}
			}else if(cur_dir == 1){
				next_y = cur_y -1;
				next_x = cur_x;
				if(arr[next_y][next_x] == 1 || arr[next_y][next_x] == 2){
					cur_dir = 0;
					check++;
				}else{
					cur_y = next_y;
					cur_dir = 0;
					break;
				}
			}else if(cur_dir == 2){
				next_y = cur_y;
				next_x = cur_x +1;
				if(arr[next_y][next_x] == 1 || arr[next_y][next_x] == 2){
					cur_dir = 1;
					check++;
				}else{
					cur_dir = 1;
					cur_x = next_x;
					break;
				}
			}else{
				next_y = cur_y+1;
				next_x = cur_x;
				if(arr[next_y][next_x] == 1 || arr[next_y][next_x] == 2){
					cur_dir = 2;
					check++;
				}else{
					cur_dir = 2;
					cur_y = next_y;
					break;
				}
			}
			
			if(check >=4){
				next_y = cur_y + my[cur_dir];
				next_x = cur_x + mx[cur_dir];
				if(arr[next_y][next_x] == 1){
					stop_flag = true;
					break;
				}else{
					cur_y = next_y;
					cur_x = next_x;
					cnt--;
					break;
				}
				
			}
			
		}
	}
	
	cout << cnt << endl;
	
	return 0;
}
