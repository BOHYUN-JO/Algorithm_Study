#include <iostream>

using namespace std;

int arr[500][500];
int dp[500][500]={0,};
int mx[4] = {0,0,-1,1};
int my[4] = {-1,1,0,0};


int Bigger(int A, int B){ return A > B ? A : B ; }

int dfs(int y, int x, int n){
	if(dp[y][x] != 0){
		return dp[y][x];
	}
	dp[y][x] = 1;
	for(int i=0; i<4 ; i++){
		int new_x = x+mx[i];
		int new_y = y+my[i];
		if(new_y < 0 || new_y >= n || new_x <0 || new_x >= n)
			continue;
		if(arr[new_y][new_x] > arr[y][x]){
			dp[y][x] = Bigger(dp[y][x], dfs(new_y, new_x, n)+1);
		}
	}
	return dp[y][x];
}


int main(){
	int n,i,j,ans=0;
	
	cin >> n;
	for(i=0; i<n; i++){
		for(j=0;j<n;j++){
			cin >> arr[i][j];
		}
	}
	
	for(i=0; i<n; i++){
		for(j=0;j<n;j++){
			ans = Bigger(ans,dfs(i,j,n));
		}
	}
	
	cout << ans << "\n";
	 
	return 0;
}
