#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int shortCut[12][3];
int dp[10001] = {0,};
int idx=0;

int main(){
	int cnt, len;
	cin >> cnt >> len;
	for(int i=0; i< cnt; i++){
		for(int j=0; j<3; j++){
			cin >> shortCut[i][j];
		}	
	}
	
	for(int i=0; i<cnt ; i++){
		for(int j=i; j< cnt; j++){
			if(shortCut[i][0] > shortCut[j][0] ){
				int temp1,temp2,temp3;
				temp1 = shortCut[j][0];
				temp2 = shortCut[j][1];
				temp3 = shortCut[j][2];
				shortCut[j][0] = shortCut[i][0];
				shortCut[j][1] = shortCut[i][1];
				shortCut[j][2] = shortCut[i][2];
				shortCut[i][0] = temp1;
				shortCut[i][1] = temp2;
				shortCut[i][2] = temp3;	
			}
		}
	}
	
	
	for(int i=1; i <= len; i++){
		dp[i] = dp[i-1] +1;
		for(int j=0; j<cnt; j++){
			if(i == shortCut[j][1]){
				if(dp[i] > dp[shortCut[j][0]] + shortCut[j][2]){
					dp[i] = dp[shortCut[j][0]] + shortCut[j][2];
				}
			}
		}
	}
	cout << dp[len];
		
	return 0;	
}
