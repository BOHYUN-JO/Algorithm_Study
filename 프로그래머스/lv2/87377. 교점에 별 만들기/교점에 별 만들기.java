import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                long child = A*D - B*C;
                
                if(child == 0 ) continue;
                
                if( (B*F - E*D) % child != 0  || (E*C - A*F) % child !=0 )  continue;
                long x = (B*F - E*D)/child;
                long y = (E*C - A*F)/child;
                
                if((x%1) !=0 || (y%1) !=0) continue;
                
                list.add(new int[] { (int)x, (int)y} );
                
                maxX = Math.max(maxX, (int)x );
                maxY = Math.max(maxY, (int)y );
                
                minX = Math.min(minX, (int)x );
                minY = Math.min(minY, (int)y );
                
            }
        }
        
        //System.out.println(maxX+" " + maxY+" " + minX + " " + minY);
        
        boolean[][] check = new boolean[Math.abs(maxY-minY)+1 ][Math.abs(maxX-minX)+1];
        
        for(int i=0; i< list.size(); i++ ){
            //System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
            int x = Math.abs( minX - list.get(i)[0] );
            int y = Math.abs( maxY - list.get(i)[1] );
            
            check[y][x] = true;
        }
        
        answer = new String[check.length];
        for(int i=0; i<check.length; i++){
            answer[i] = "";
            for(int j=0; j<check[i].length; j++){
                if(check[i][j]){
                    answer[i] += "*";
                }else{
                    answer[i] += ".";
                }
            }
        }
        
        
        return answer;
    }
}