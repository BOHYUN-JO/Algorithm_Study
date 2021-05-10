#include <cstdio>

using namespace std;


int main(){
	long long int dp[91];
	long long int sum[91];
	int i,n;
	sum[1] = 1;
	sum[2] = 2;
	sum[3] = 4;
	dp[1] = 1;
	dp[2] = 1;
	dp[3] = 2;
	for(i=4; i<91 ; i++){
		dp[i] = 1+ sum[i-2]; 
		sum[i] = sum[i-1] + dp[i];
	}
	
	scanf("%d", &n);
	printf("%lld\n", dp[n]);
	
	
	return 0;
}
