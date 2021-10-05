#include <bits/stdc++.h>

using namespace std;

int N;
int arr[101][101];
int my[4] = {0,-1,0,1};
int mx[4] = {1,0,-1,0};

void draw(int x,int y, int d, int g){
	vector<int> v;
	int idx = 0;
	arr[y][x] = 1;
	y += my[d];
	x += mx[d];
	arr[y][x] = 1;
	v.push_back(d);
	idx = 1;
	
	for(int i=0; i<g; i++){
		for(int j=v.size()-1; j>=0 ; j--){
			v.push_back( (v[j]+1) % 4);
		}
		int dir;
		for( ; idx<v.size(); idx++){
			dir = v[idx];
			y += my[dir];
			x += mx[dir];
			arr[y][x] = 1;
		}
	}
}

int main(){
	int x,y,d,g;
	cin >> N;
	for(int i=0; i<N; i++){
		cin >> x >> y >> d >> g;
		draw(x,y,d,g);	
	}
	
	int sum = 0;
	for(int i=0; i<100; i++){
		for(int j=0; j<100; j++){
			if(arr[i][j] == 1 && arr[i+1][j] ==  1 && arr[i][j+1] == 1 && arr[i+1][j+1] == 1){
				sum++;
			}
		}
	}
	cout << sum << endl;
	
	return 0;
}
