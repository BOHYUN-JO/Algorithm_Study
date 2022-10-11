import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s<n){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        
        int div = s/n;
        int mod = s%n;
        
        for(int i=0; i<n; i++){
            answer[i] = div;
        }
        
        for(int i=n-1; i>=0; i--){
            if(mod ==0 ) break;
            answer[i]++;
            mod--;
        }
        
        return answer;
    }
}