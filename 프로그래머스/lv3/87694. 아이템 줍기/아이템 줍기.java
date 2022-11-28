import java.util.*;

class Solution {
    public static boolean[][] inner;
    public static boolean[][] outer;
    public static class Point{
        int x;
        int y;
        int cost;
        Point(int x, int y, int cost){
            this.x = x;
            this.y = y ;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 987654321;
        
        inner = new boolean[102][102];
        outer = new boolean[102][102];
        boolean[][] visited = new boolean[102][102];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        for(int i=0; i<rectangle.length; i++){
            int sx = rectangle[i][0]*2;
            int sy = rectangle[i][1]*2;
            int ex = rectangle[i][2]*2;
            int ey = rectangle[i][3]*2;
            for(int y=sy; y<=ey; y++){
                for(int x=sx; x<=ex; x++){
                    if(y==sy || y==ey){
                        if(!inner[y][x]){
                            outer[y][x] = true;
                        } 
                    }else{
                        if(x==sx || x == ex){
                            if(!inner[y][x]){
                                outer[y][x] = true;
                            } 
                        }else{
                            inner[y][x] = true;
                        }
                    }
                }
            }
        }
        
        Queue<Point> q = new LinkedList<>();
        visited[characterY*2][characterX*2] = true;
        
        q.add(new Point(characterX*2, characterY*2, 0));
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            //System.out.println("X: "+cur.x+" Y: "+cur.y+ " cost: "+cur.cost);
            if(cur.x == itemX*2 && cur.y == itemY*2){
                answer = Math.min(answer, cur.cost/2);
            }
            
            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(nx <1 || ny <1 || nx > 101 || ny > 101 ) continue;
                
                if(!visited[ny][nx] && !inner[ny][nx] && outer[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new Point(nx, ny, cur.cost+1));
                }
            }
            
        }
   
        
                
        
        return answer;
    }
}