import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
                   
        for(long i=left; i<=right; i++){
            int blockNum = (int)(i/n)+1; 
            int innerNum = (int)(i%n);
            //System.out.println(blockNum);
            if( innerNum < blockNum ){
                answer[(int)(i-left)] = blockNum;
            }else{
                answer[(int)(i-left)] = innerNum+1;
            }
        }              
        
        return answer;
    }
}