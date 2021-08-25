#include <iostream>
#include <vector>

using namespace std;

int findMax(int idx, int arr[]){
    int tmax = 0;
    for(int i=0; i<4; i++){
        if(i==idx) continue;
        if(tmax < arr[i]){
            tmax = arr[i];
        }
    }
    return tmax;
}

int solution(vector<vector<int> > land)
{
    int answer = 0;
    int dp[100001][4];
    for(int i=0; i<100001; i++){
        for(int j=0; j<4; j++){
            dp[i][j] = 0;
        }
    }
    
    for(int i=0; i<4; i++){
        dp[0][i] = land[0][i];
    }
    
    for(int i=1;i<land.size();i++){
        for(int j=0; j<4; j++){
            dp[i][j] = land[i][j] + findMax(j,dp[i-1]);
        }        
    }
    
    answer = findMax(4, dp[land.size()-1]);
    
    return answer;
}
