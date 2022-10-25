import java.util.*;

class Solution {
    static HashSet<Integer> ansDict = new HashSet<>();
    static int[] preSum;
    public int solution(int[] elements) {
        int answer = 0;
        
        preSum = new int[elements.length+1];
        
        int sum = 0 ;
        for(int i=1; i<elements.length+1; i++){
            preSum[i] = preSum[i-1] + elements[i-1];
        } 
        
        for(int i=0; i<elements.length; i++){
            count(i+1, elements.length);
        }
          
        
        return ansDict.size();
    }
    
    public static void count(int len, int maxLen){
        for(int i=0; i<maxLen; i++){
            if(i+len > maxLen){
                ansDict.add(preSum[maxLen]-preSum[i]+preSum[(i+len)%maxLen]);
            }else{
                ansDict.add(preSum[i+len]-preSum[i]);
            }
        }
    }
}