import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i]; 
        }
        
        long half = (sum1+sum2)/2;
        
        while(true){
            if(sum1 == half && sum2 == half) break;
            
            if(answer > queue1.length*3) break;
            
            if(sum1 > half){
                int front = q1.poll();
                sum1 -= front;
                q2.add(front);
                sum2 += front;
               
            }else{
                int front = q2.poll();
                sum2 -= front;
                q1.add(front);
                sum1 += front;
            }
            
            answer++;
            
        }
        
        if(answer > queue1.length*3) answer = -1;
        
                
        return answer;
    }
    
}