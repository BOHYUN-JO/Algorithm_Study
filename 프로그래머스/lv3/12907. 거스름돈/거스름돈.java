import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    public int solution(int n, int[] money) {
        int answer = 0;
              
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=0; i<money.length; i++){
            for(int j=1; j<=n; j++){
                if(j-money[i] >=0){
                    dp[j] += dp[j-money[i]];
                }
            }
        }
                        
        return dp[n];
    }
}