import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        int min = 0;
        int max = n*cores[0];
        int time = 0;
        int m = 0;
        
        
        while(min <=max){
            int mid = (min+max)/2;
            
            int cnt = count(mid, cores);
            
            if(cnt >= n){
                max = mid-1;
                time = mid;
                m = cnt;
            }else{
                min = mid+1;
            }
        }
        
        m -= n;
        for(int i = cores.length-1; i>=0; i--){
            if (time % cores[i] == 0) { 
                if (m == 0) {
                    answer = i+1;
                    break;
                }
                m--;
            }
        }
                        
        return answer;
    }
    
    public static int count(int time, int[] cores){
        if(time == 0){
            return cores.length;
        }
        
        int cnt = cores.length;
        for(int i=0; i<cores.length; i++){
            cnt += time/cores[i];
        }
        
        return cnt;
    }
}