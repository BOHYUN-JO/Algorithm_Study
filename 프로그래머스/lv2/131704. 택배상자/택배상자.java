import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;
        
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
                
        for(int i=0; i<len; i++){
            q.add(i+1);        
        }
        
        int idx = 0;
        while(idx < len){
            if(!q.isEmpty()){
                if(q.peek() < order[idx]){
                    st.add(q.poll());
                }else if(q.peek() == order[idx]){
                    idx++;
                    q.poll();
                    answer++;
                }else{
                    if(!st.isEmpty() && st.peek() == order[idx]){
                        idx++;
                        st.pop();
                        answer++;
                    }else break;
                }
            }else{
                if(!st.isEmpty() && st.peek() == order[idx]){
                    idx++;
                    st.pop();
                    answer++;
                }else break;
            }
        }
        
                
        return answer;
    }
}