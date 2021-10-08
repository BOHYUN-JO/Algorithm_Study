#include <bits/stdc++.h>

using namespace std;

int root[51];
bool truth[51];

int find(int x) {
    if (root[x] == x) {
        return x;
    } else {
        return find(root[x]);
    }
}

void union1(int x, int y){
    x = find(x);
    y = find(y);
    if(x<y) root[y] = x;
    else root[x] = y;
}

int main(){
	int N,M, t, tmp;
	vector<int> v[51];
	vector<int> lie;
	
	fill(truth, truth+51, false);
	cin >> N >> M;
	cin >> t;
	for(int i=0; i<t ; i++){
		cin >> tmp;
		truth[tmp] = true;
		lie.push_back(tmp);
	}
	
	for(int i=1; i<=N; i++){
		root[i] = i;
	}
	
	for(int i=0; i<M; i++){
		cin >> t;
		for(int j=0; j<t; j++){
			cin >> tmp;
			v[i].push_back(tmp);
		}
		sort(v[i].begin(), v[i].end());
		for(int j=0; j<v[i].size()-1; j++){
			union1(v[i][j], v[i][j+1]); 
		}
	}
	for(int i=0; i<lie.size(); i++){
		truth[root[lie[i]]] = true;
	}
	
	int cnt = M;
	for(int i=0; i<M; i++){
		for(int j=0; j<v[i].size(); j++){
			if( truth[ root[v[i][j]] ] ){
				cnt--;
				break;
			}
		}
	}
	
	cout << cnt << endl;
	
	return 0;
}
