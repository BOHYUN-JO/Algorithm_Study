import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        while(n > 0){
            int mod = n%3;
            
            if(mod == 0){
                answer = "4" + answer;
                n = n/3 -1;
            }else{
                answer = String.valueOf(mod) + answer;
                n /= 3;
            }
                        
        }
        
        
        return answer;
    }
}