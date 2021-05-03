#include <cstdio>

using namespace std;

int max(int a, int b){
	return a>b?a:b;
}

int main(){
	int dp[501][501] = {0,};
	int n,i,j;
	scanf("%d", &n);
	for(i=1; i<n+1; i++){
		for(j=1; j<i+1; j++){
			scanf("%d", &dp[i][j]);
		}
	}
	
	for(i=n-1; i>0; i--){
		for(j=1; j<=i; j++){
			dp[i][j] = max(dp[i+1][j]+dp[i][j] , dp[i+1][j+1]+ dp[i][j]);
		}
	}
	
	printf("%d", dp[1][1]);
	
}
