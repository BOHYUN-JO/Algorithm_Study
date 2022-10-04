import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] tokens = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<tokens.length; i++){
            int num = Integer.valueOf(tokens[i]);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        answer = min +" " + max;
        
        return answer;
    }
}