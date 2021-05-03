#include <cstdio>

using namespace std;

int max(int a, int b){
	return a > b ? a : b;
}

int main(){
	int t, n,i,j;
	int arr[2][100001] ={0,};
	int dp[2][100001] = {0,};
	
	scanf("%d", &t);
	while(t--){
		scanf("%d", &n);
		for(i=0; i<2; i++){
			for(j=0; j<n ; j++){
				scanf("%d", &arr[i][j]);
			}
		}
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[0][1] = arr[0][1] + dp[1][0];
		dp[1][1] = arr[1][1] + dp[0][0];
		
		for(i=2; i<n ; i++){
			dp[0][i] = arr[0][i] + max(dp[1][i-1], dp[1][i-2]);
			dp[1][i] = arr[1][i] + max(dp[0][i-1], dp[0][i-2]);
		}
		
		printf("%d\n", max(dp[0][n-1], dp[1][n-1]));
		
		for(i=0; i<100001; i++){
			arr[0][i] = 0;
			dp[0][i] = 0;
			arr[1][i] = 0;
			dp[1][i] = 0;
		}
	} 
	
	
	return 0;
}
