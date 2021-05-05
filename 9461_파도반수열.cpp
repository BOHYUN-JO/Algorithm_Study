#include <cstdio>
#include <cstring>

using namespace std;

int main(){
	int T,i,n;
	long long dp[101];
	scanf("%d", &T);
	while(T--){
		
		scanf("%d", &n);
		dp[1] = dp[2] = dp[3] = 1;
		
		for(i=3; i<=n; i++){
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		printf("%lld\n", dp[n]);
	}
}
