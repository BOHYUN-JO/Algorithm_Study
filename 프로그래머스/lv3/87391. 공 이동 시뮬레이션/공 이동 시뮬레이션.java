import java.util.*;

class Solution { 
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;
        // 좌상단
        int x1 = x;
        int y1 = y;
        // 우하단
        int x2 = x;
        int y2 = y;
        
        for(int i=queries.length-1; i>=0; i--){
            int dir = queries[i][0];
            int dx = queries[i][1];
            //System.out.println("x1:" +x1 + " y1:" +y1 +", x2:" + x2 + " y2: " + y2);
            if(dir == 0){
                if(y1 != 0){
                    y1 = y1 + dx;
                }
                
                y2 = y2+dx;
                
                if(y2 >= m){
                    y2 = m-1;
                }
            }else if(dir == 1){
                if(y2 != m-1){
                    y2 = y2 - dx;
                }
                y1 = y1 - dx;
                if(y1 < 0){
                    y1 = 0;
                }
            }else if(dir == 2){
                if(x1 != 0){
                    x1 = x1 + dx;
                }
                
                x2 = x2 + dx;
                if(x2 >= n){
                    x2 = n-1;
                }
            }else{
                if(x2 != n-1){
                    x2 = x2 -dx;
                }
                
                x1 = x1-dx;
                if(x1 <0){
                    x1 = 0;
                }
            }
            
            if(x1 >= n || y1 >= m || x2 <0 || y2 < 0 ) return 0;
        }
        
        answer = ((long)x2-(long)x1+1)*((long)y2-(long)y1+1);
                            
        return answer;
    }
}