import java.io.*;
import java.util.*;

public class Baekjoon_1039 {
    static boolean visit[][] = new boolean[1000001][11];
    static int N,K;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        N = Integer.parseInt(str);
        K = Integer.parseInt(st.nextToken());
        bfs();
        
    }
    private static void bfs() {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(N, 0));
        visit[N][0] = true;
        while(!q.isEmpty()) {
            
        	if(q.peek().y == K ) break;
        	
            Point cur = q.poll();
            
            for(int i=0; i<str.length()-1; i++) {
                for(int j=i+1; j<str.length(); j++) {
                    int next = solve(cur.x,i,j);
                    if(next != -1 && !visit[next][cur.y+1]) {
                        visit[next][cur.y+1] = true;
                        q.add(new Point(next, cur.y+1));
                    }
                }
            }
        }
        
        int ans = -1;
        while(!q.isEmpty()) {
            Point po = q.poll();
     
            if(ans < po.x)
                ans = po.x;
        }
        
        System.out.println(ans);
        
        
    }
    private static int solve(int x, int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        if(i==0 && sb.charAt(j)=='0')
            return -1;
        
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
        
        return Integer.parseInt(sb.toString());
    }
    
    static class Point{
    	int x;
    	int y;
    	Point(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
}
