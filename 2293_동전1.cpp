#include <iostream>

#define endl "\n";
#define MAX 110
using namespace std;

int n,k;
int arr[MAX];
int dp[10010]={0,};
	
int main(){
		
	cin >> n >> k;
	for(int i=1; i<=n; i++){
		cin >> arr[i];
	}
	dp[0] = 1;
	for(int i=1; i<=n; i++){
		for(int j = arr[i]; j <= k; j++){
			dp[j] = dp[j] + dp[j - arr[i]];
		}
	}
	cout << dp[k] << endl;
	
	return 0; 
}
