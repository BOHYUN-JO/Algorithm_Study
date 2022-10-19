import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1,o2) -> o1[1]-o2[1]);        
        
        int lastCam = routes[0][1];
        
        for(int i=1; i<routes.length; i++){
            if(lastCam <= routes[i][1] && routes[i][0] <= lastCam ){
                continue;
            }else{
                lastCam = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}