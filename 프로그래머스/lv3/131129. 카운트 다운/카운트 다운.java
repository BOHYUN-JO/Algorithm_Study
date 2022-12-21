import java.util.*;

class Solution {
    static int[][] dp = new int[100001][2];  
    
    public static void check(int score, int max){
        int minNumOfDart = score;
        int maxNumOfSingleOrBull = 0;
        
        for(int i = 1; i<= max; i++){
            if(dp[i][0] != 1) continue;
                        
            int before = score - i;
            
            int beforeDart = dp[before][0];
            int beforeSorB = dp[before][1];
            
            int expectedDart = beforeDart + 1;
            int expectedSorB = beforeSorB + ((dp[i][1] == 1) ? 1 : 0);
            
            if(expectedDart < minNumOfDart || (expectedDart == minNumOfDart) && expectedSorB > maxNumOfSingleOrBull  ){
                minNumOfDart = expectedDart;
                maxNumOfSingleOrBull = expectedSorB;
            }
        }
        
        dp[score][0] = minNumOfDart;
        dp[score][1] = maxNumOfSingleOrBull;
    }
    
    public int[] solution(int target) {
        int[] answer = new int[2];
                
        for(int i=1; i<=20; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
            dp[i*2][0] = 1;
            dp[i*2][1] = 0;
            dp[i*3][0] = 1;
            dp[i*3][1] = 0;
        }
        
        dp[50][0] = 1;
        dp[50][1] = 1;
        
        for(int score=21; score<=target; score++){
            if( score <= 60){
                if(dp[score][0] == 0){
                    check(score, score-1);
                }
            }else{
                check(score, 60);
            }     
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
                                
        return answer;
    }
    
}