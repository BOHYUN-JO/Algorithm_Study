import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int start = 1;
        for(int i=0; i<stations.length; i++){
            int end = stations[i];
            int max = end - w;
            int gap = max - start;
            //System.out.println(Math.ceil( (double)gap/(double)(w*2+1) ));
            answer += Math.ceil( (double)gap/(double)(w*2+1) );
            
            if(i < stations.length-1){
                start = Math.min(end+w+1, stations[i+1]);
            }else{
                gap = n-end-w;
                if(gap <=0 ) break;
                //System.out.println(Math.ceil( (double)gap/(double)(w*2+1) ));
                answer += Math.ceil( (double)gap/(double)(w*2+1) );
            }
        }

        return answer;
    }
}