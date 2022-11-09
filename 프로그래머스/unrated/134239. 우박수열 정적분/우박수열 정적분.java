import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int len = ranges.length;
        double[] answer = new double[len];
        LinkedList<Integer> list = new LinkedList<>();
        
        int size = 0;
        
        while(k!=1){
            list.add(k);
            if(k %2 ==0){
                k/=2;
            }else{
                k = k*3 +1;
            }
            size++;
        }
        
        list.add(1);
        
        double[] preSum = new double[list.size()+1];
        
        double sum = 0;
        for(int i=0; i<list.size()-1; i++){
            sum += (list.get(i)+list.get(i+1))/2.0;
            //System.out.println(sum);
            preSum[i+1] = sum; 
        }
    
        for(int i=0; i<len; i++){
            if(ranges[i][0] > size+ranges[i][1]){
                answer[i] = -1.0;
            }else{
                answer[i] = preSum[size+ranges[i][1]] - preSum[ranges[i][0]];
            }
            
        }
        
        return answer;
    }
}