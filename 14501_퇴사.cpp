#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
int tmax = 0;

void dfs(vector<int>& T, vector<int>& P, int idx,  int sum){
	
	if(sum > tmax){
		tmax = sum;
	}
	
	if(idx >=N) return;
	
	if(idx+T[idx] <= N){
		dfs(T,P,idx+T[idx], sum+P[idx]);
	}
	
	if(idx+1 < N){
		dfs(T,P,idx+1, sum);
	}
		
}

int main(){
	vector<int> T;
	vector<int> P;
	cin >> N;
	for(int i=0; i<N;i++){
		int a,b;
		cin >> a >> b;
		T.push_back(a);
		P.push_back(b);
	}
	
	
	dfs(T,P,0, 0);
	
	cout << tmax;
	return 0;  
}
