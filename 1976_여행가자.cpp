#include <bits/stdc++.h>

using namespace std;

int root[201];

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
	int N, M, tmp;
	vector<int> plan;
	cin >> N;
	cin >> M;
	
	for(int i=0; i<201; i++){
		root[i] = i;
	}
	
	for(int i=1; i<=N; i++){
		for(int j=1; j<=N; j++){
			cin >> tmp;
			if(tmp == 1){
				union1(i,j);
			} 
		}
	}
	
	for(int i=0; i<M; i++){
		cin >> tmp;
		plan.push_back(tmp);
	}
	
	for(int i=1; i<plan.size(); i++){
		if(find(plan[i] ) != find(plan[0]) ){
			cout << "NO" << endl;
			return 0;
		}
	}
	cout << "YES" << endl;
	
	return 0;
}
