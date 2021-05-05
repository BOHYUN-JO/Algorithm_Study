#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

int Bigger(int a, int b){
	return a>b ? a : b;
}

int main(){
	int n,i, tmp;
	vector<int> v[501];
	int dp[501] = {0,};
	int pre[501], build[501];
	queue<int> q;
	
	scanf("%d", &n);
	for(i=1; i <= n; i++){
		scanf("%d", &build[i]);
		while(1){
			scanf("%d", &tmp);
			if(tmp == -1){
				break;
			}
			v[tmp].push_back(i);
			pre[i]++;
		}	
	}
	
	for(i=1; i<=n; i++){
		if(pre[i] == 0){	// there is no pre-building
			q.push(i);
			dp[i] = build[i];
		}
	}
	
	while(!q.empty()){
		int cur = q.front();
		q.pop();
		
		for(i=0; i<v[cur].size(); i++){
			int next = v[cur][i];
			pre[next]--;
			dp[next] = Bigger(dp[next], dp[cur]+ build[next]);
			if(pre[next] == 0){
				q.push(next);
			}
		}
	}
	
	for(i=1; i<=n ; i++){
		printf("%d\n", dp[i]);
	}
	
		
	return 0; 
}
