#include <bits/stdc++.h>

using namespace std;

int arr[51][51];
int N,M;

int check(vector<pair<int,int> >& v){
	int ret =0, tmp=0;
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			if(arr[i][j] == 1){
				int tmin = 1e9;
				for(int k=0; k<v.size(); k++ ){
					tmp = abs(i-v[k].first) + abs(j-v[k].second);
					if(tmin > tmp) tmin = tmp;
				}
				ret += tmin;
			}
		}
	}
	return ret;
}

int main(){
	int chicken=0,tmin = 1e9;
	
	vector<pair<int,int> > v;
	vector<int> ind;

	cin >> N >> M;
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			cin >> arr[i][j];
			if(arr[i][j] == 2){
				v.push_back({i,j});
				chicken++;
			}
		}
	}	
	
	for(int i=0; i<M; i++){
		ind.push_back(1);
	}
	for(int i=0; i<chicken-M; i++){
		ind.push_back(0);
	}
	sort(ind.begin(), ind.end());
	
	do{
		vector<pair<int,int> > pos;
		int tmp = 0;
		for(int i=0; i<chicken; i++){
			if(ind[i] == 1){
				pos.push_back(v[i]);
			}
		}
		tmp = check(pos);
		if(tmp < tmin) tmin = tmp;
						
	}while(next_permutation(ind.begin(), ind.end()));
	
	cout << tmin << endl;	
	
	return 0;
}
