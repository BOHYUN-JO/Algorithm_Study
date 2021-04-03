#include <iostream>
#include <vector>
#include <algorithm>
#include <utility>

using namespace std;

int main(){
	int T, N, tmp1, tmp2,cnt=1, bound;
	vector< pair<int, int> > v;
	cin >> T;
	for(int i=0; i<T; i++){
		cin >> N;
		for(int j=0; j<N; j++){
			cin >> tmp1 >> tmp2;
			v.push_back(make_pair(tmp1, tmp2));
		}
		sort(v.begin(), v.end());
		bound = v[0].second;
		for(int k=1; k<N; k++){
			if(bound > v[k].second){
				cnt++;
				bound = v[k].second;
			}
		}
		cout << cnt << endl;
		cnt = 1;
		v.clear();
	} 
}
