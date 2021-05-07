#include <cstdio>

using namespace std;

int main(){
	long long int dp[1001][10];
	int n, i, j;
	long long int ans;
	scanf("%d", &n);
	
	for(i=0; i<10; i++){
		dp[1][i] = (i+1);
	}
	
	for(i=2; i<1001; i++){
		dp[i][0] = dp[i-1][0];
		for( j = 1; j<10 ; j++){
			dp[i][j] = dp[i][j-1] + dp[i-1][j];
			dp[i][j] = dp[i][j] % 10007;
		}
	}
	
	ans = dp[n][9];
	ans = ans % 10007;
	printf("%d", ans);
	
	return 0;
}
