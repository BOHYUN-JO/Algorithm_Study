import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e9 * 2 * 10e5 * 2);;
        long start = 0;
        long mid, end = (long) (10e9 * 2 * 10e5 * 2);
        
        while(start <= end){
            mid = (start+end)/2;
            int gold = 0;
            int silver = 0;
            int total = 0;
            
            for(int i=0; i<s.length; i++){
                int curGold = g[i];
                int curSilver = s[i];
                int curWeight = w[i];
                long curTime = t[i];
                
                long moveCnt = mid/(curTime*2);
                if(mid%(curTime*2) >= curTime){
                    moveCnt++;
                }
                
                gold += Math.min(curGold, moveCnt*curWeight);
                silver += Math.min(curSilver, moveCnt*curWeight);
                total += Math.min(curGold+curSilver, moveCnt*curWeight);     
            }
            
            if(a <= gold && b <= silver && (a+b) <= total){
                end = mid-1;
                answer = Math.min(answer, mid);
            }else{
                start = mid+1;
            }
        }
                                
        return answer;
    }
}