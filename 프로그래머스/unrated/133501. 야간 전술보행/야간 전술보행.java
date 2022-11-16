import java.util.*;

class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 100000000;
        
        for(int i=0; i<scope.length; i++){
            int scope1 = Math.min(scope[i][0], scope[i][1]);
            int scope2 = Math.max(scope[i][0], scope[i][1]);
            
            int start = 1;
            int end = times[i][0];
            
            while(start <= scope2){
                boolean flag = false;
                for(int j=start; j<=end; j++){
                    if(scope1 <= j && j <= scope2){
                        answer = Math.min(answer, j);
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
                
                start += times[i][0] + times[i][1];
                end += times[i][0] + times[i][1];
            }
         
        }
        
        if(answer == 100000000){
            answer = distance;
        }
        
        return answer;
    }
}