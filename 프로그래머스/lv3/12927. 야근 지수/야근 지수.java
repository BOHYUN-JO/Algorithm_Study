import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        while(n > 0){
            int front = pq.poll();
            if(front == 0) break;
            
            pq.add(front-1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num*num;
        }
        
        
        return answer;
    }
}