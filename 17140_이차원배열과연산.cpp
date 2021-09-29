#include <bits/stdc++.h>

using namespace std;

int arr[101][101] = {0,};
int r,c,k;

bool cmp(pair<int,int> p1, pair<int,int> p2){
	if(p1.second == p2.second){
		return p1.first < p2.first;
	}
	
	return p1.second < p2.second;
}

int R(int w, int h){
	int tmax=0;;
	
	for(int i=0; i<h; i++ ){
		map<int,int> m;
		vector<pair<int,int> > tmp;
		int len=0;
		for(int j=0; j<w; j++){
			len++;
			if(arr[i][j] == 0) continue;
			if(m.find(arr[i][j]) != m.end()){
				m[arr[i][j]] += 1;
			}else{
				m[arr[i][j]] = 1;
			}
		}
		for(auto it : m){
			tmp.push_back({it.first, it.second});
		}
		sort(tmp.begin(), tmp.end(), cmp);	
		int idx = 0;
		for(auto it : tmp){
			arr[i][idx++] = it.first;
			arr[i][idx++] = it.second;
			if(idx > 100) break;
		}
		for(int k=idx; k<len; k++){
			arr[i][k] = 0;
		}
		
		if(idx > tmax) tmax = idx;
	}
	
	return tmax;
}

int C(int w, int h){
	int tmax = 0;
	
	for(int i=0; i<w; i++ ){
		map<int,int> m;
		vector<pair<int,int> > tmp;
		int len = 0;
		for(int j=0; j<h; j++){
			len++;
			if(arr[j][i] == 0) continue;
			if(m.find(arr[j][i]) != m.end()){
				m[arr[j][i]] += 1;
			}else{
				m[arr[j][i]] = 1;
			}
		}
		for(auto it : m){
			tmp.push_back({it.first, it.second});
		}
		sort(tmp.begin(), tmp.end(), cmp);	
		int idx = 0;
		for(auto it : tmp){
			arr[idx++][i] = it.first;
			arr[idx++][i] = it.second;
		}
		for(int k=idx; k<len; k++){
			arr[k][i] = 0;
		}
		if(idx > tmax) tmax = idx;
	}
	
	return tmax;
}

int main(){
	int tmp, w=3,h=3, cnt = 0;
	cin >> r >> c >> k;
	for(int i=0; i<3; i++){
		for(int j=0; j<3; j++){
			cin >> arr[i][j];
		}
	}
	
	while(1){
		if(arr[r-1][c-1] == k){
			break;
		}
		if(h >= w){
			w = R(w,h);
			if(w>100) w=100;
		}else{
			h = C(w,h);
			if(h>100) h=100;
		}
		
		cnt++;
		if(cnt >100){
			cnt = -1;
			break;
		}
	}
	
	cout << cnt << endl;
	
	return 0;
}
