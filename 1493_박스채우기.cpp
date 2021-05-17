#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int cube[20];
vector<pair<int, int> > v;
int cnt = 0;
int flag = 0;

void dnc(int l,int w,int h, int idx){
	if( l == 0 || w==0 || h == 0){
		return;
	}
	
	for(int i=idx; i< v.size(); i++){
		if(v[i].second != 0 && l >= v[i].first && w >= v[i].first && h >= v[i].first){
			v[i].second--;
			cnt++;
			int tmp = v[i].first;
			dnc(l-tmp, w, h, i);
			dnc(tmp, w-tmp, h, i);
			dnc(tmp, tmp, h-tmp, i);
			return;
		}
	}
	flag = 1;
}

int main(){
	int L,W,H, n, a, b, ans;
	cin >> L >> W >> H;
	cin >> n;
	for(int i=0; i< n; i++){
		cin >> a >> b;
		cube[a] += b;
	}
	
	for(int i= 19; i >= 0; i--){
		if(cube[i] != 0){
			v.push_back(make_pair(pow(2,i), cube[i]));
		}
	}
	
	dnc(L,W,H,0);
	if(flag){
		cout << -1 << endl;
	}else{
		cout << cnt << endl;
	}
	
	
	return 0; 
}
