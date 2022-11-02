import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        left.put(topping[0], 1);
        
        for(int i=1; i<topping.length; i++){
            right.compute(topping[i], (k,v) -> v==null ? 1 : v+1 );
        }
        
        for(int i=0; i<topping.length-1; i++){
            if(left.size() == right.size()){
                answer++;
            }
            left.compute(topping[i+1], (k,v) -> v==null ? 1 : v+1 );
            right.put(topping[i+1], right.get(topping[i+1])-1);
            if(right.get(topping[i+1]) ==0 ){
                right.remove(topping[i+1]);
            }
        }
        
                
        return answer;
    }
}