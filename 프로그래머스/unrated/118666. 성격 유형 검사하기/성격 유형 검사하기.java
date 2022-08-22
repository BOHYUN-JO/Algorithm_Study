import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[] cnt = new int[26];
        
        for(int i=0; i<choices.length; i++){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            if(choices[i] > 4){
                cnt[second-'A'] += choices[i] - 4;
            }else if(choices[i] < 4){
                cnt[first-'A'] += 4 - choices[i];
            }
        }
        
        answer += compare(cnt, 'T', 'R');
        answer += compare(cnt, 'F', 'C');
        answer += compare(cnt, 'M', 'J');
        answer += compare(cnt, 'N', 'A');
            
        return answer;
    }
    
    public static String compare(int[] cnt, char x, char y){
        if(cnt[x-'A'] > cnt[y-'A']) return String.valueOf(x);
        else return String.valueOf(y);
    }
    
}