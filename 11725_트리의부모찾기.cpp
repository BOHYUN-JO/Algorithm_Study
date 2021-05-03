#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int check[100001] ={0,};
int ans[100001];

void dfs(vector<int> *v, int parent){
	check[parent] = 1;
	
	for(int i=0; i< v[parent].size(); i++){
		int tmp = v[parent][i];
		if(!check[tmp]){
			ans[tmp] = parent;
			dfs(v,tmp);
		}
	}
}

int main(){
	int n, i, tmp1, tmp2;
	vector<int> *v;
	stack<int> st;
	
	cin >> n;
	v = new vector<int>[n+1];
	for(i=0; i<n-1; i++){
		cin >> tmp1 >> tmp2;
		v[tmp1].push_back(tmp2);
		v[tmp2].push_back(tmp1);
	}
	
	dfs(v,1);
	
	for(i=2; i<=n; i++){
		cout << ans[i] << endl;
	}
	
	
	return 0;
}
