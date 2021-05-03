#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main(){
	int N,M,a,b,i,j, tmp, flag=1, cnt =0;;
	vector<int> v[501];
	int check[501] = {0,};
	int count[501] = {0,};
	int child[501] = {0,};	
	stack<int> st;
	
	cin >> N >> M;
	
	
	for(i=0; i<M; i++){
		cin >> a >> b;
		v[a].push_back(b);		
	} 
	
	for(i=1; i<=N; i++){
		st.push(i);
		while(!st.empty()){
			tmp = st.top();
			st.pop();
			for(j=0; j<v[tmp].size(); j++){
				if(check[v[tmp][j]] == 0){
					child[i]++;
					check[v[tmp][j]] = 1;
					count[v[tmp][j]]++;
					st.push(tmp);
					st.push(v[tmp][j]);
					break;
				}
			}
		}
		for(j=1; j<=N; j++){
			check[j] = 0;
		}
	}	
	
	for(i=1; i<=N; i++){
		if( (count[i]+child[i]) == N-1){
			cnt++;
		}
	}
	
	cout << cnt << endl;
	return 0;
}
