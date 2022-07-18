import java.util.*;

class Programmers_Á¤¼ö»ï°¢Çü {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[501][501];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                dp[i][j] = Math.max(dp[i-1][Math.max(0, j-1)], dp[i-1][Math.min(j,i-1)])+triangle[i][j];
            }
        }
        
        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }       
        
        return answer;
    }
}