import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        boolean spaceFlag = true;
       
        // 무식한 방법
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                answer += " ";
                spaceFlag = true;
            }else if( Character.isDigit(s.charAt(i)) ){
                answer += s.charAt(i);
                spaceFlag = false;
                continue;
            }else{
                if(spaceFlag ){
                    if( s.charAt(i) >='a' && s.charAt(i) <='z' ){
                        answer += String.valueOf( (char)(s.charAt(i)-32));
                    }else{
                        answer += String.valueOf( (char)(s.charAt(i)));
                    }
                }else{
                    if( s.charAt(i) >='a' && s.charAt(i) <='z' ){
                        answer +=  String.valueOf( (char)(s.charAt(i)));
                    }else{
                        answer += String.valueOf( (char)(s.charAt(i)+32));
                    }
                }
                spaceFlag = false;
            }
        }
        
        return answer;
    }
}