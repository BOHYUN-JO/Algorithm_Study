#include <bits/stdc++.h>

using namespace std;

int main(){
	int N,K,L;
	int arr[101][101];
	map<int, char> m;
	deque<pair<int,int> > snake;
	
	fill(arr[0], arr[101], 0);
	cin >> N;
	cin >> K;
	for(int i=0; i<K; i++){
		int y,x;
		cin >> y >> x;
		arr[y][x] = 1;
	}
	cin >> L;
	for(int i=0; i<L; i++){
		int x; char c;
		cin >> x >> c;
		m[x] = c;
	}
	
	snake.push_back({1,1});
	
	int cnt = 0;
	int my[4] = {0,1,0,-1};
	int mx[4] = {1,0,-1,0};
	int dir=0;
	int cur_y,cur_x, next_y, next_x;
	bool flag = true;
	while(flag){
		cnt++;
		cur_y = snake.front().first;
		cur_x = snake.front().second;
		
		next_y = cur_y + my[dir];
		next_x = cur_x + mx[dir];
		if(next_y <1 || next_x <1 || next_y > N || next_x > N){
			break;
		}
		
		for(auto it : snake){
			if(it.first == next_y && it.second == next_x){
				flag = false;
				break;
			}
		}
		if(!flag) break;
		
		if(arr[next_y][next_x] == 1){	// 사과가 있는 경우 
			arr[next_y][next_x] = 0;
			snake.push_front({next_y, next_x});
		}else{	// 사과가 없는 경우 
			snake.push_front({next_y,next_x});
			snake.pop_back();
		}
		
		if(m.find(cnt) != m.end()){
			if(m[cnt] == 'L'){
				dir = (dir-1)<0 ? 3 : dir-1;
			}else{
				dir = (dir+1)>3 ? 0 : dir+1;
			}
		}
					
	}
	
	cout << cnt << endl;
	
	return 0;
}
