#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
    long long answer = 0;
    long long dp[2000];
    dp[0] = 0; dp[1] = 1; dp[2] = 2;
    if(n<3) 
        return dp[n];
    
    for(int i=3; i<=n; i++){
        dp[i] = (dp[i-1] + dp[i-2])%1234567;
    }
    return dp[n];
    
}
