import java.io.*;
import java.util.*;


public class Baekjoon_14466 {
	static int N,K,R,ans;
	static boolean visit[][][][],check[][];
	static Pair p[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1][N+1][N+1][N+1];
		for(int i=0; i<R ; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			visit[x1][y1][x2][y2] = true;
			visit[x2][y2][x1][y1] = true;
		}
		
		p = new Pair[K];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) );
		}
		
		for(int i=0; i<K; i++) {
			check = new boolean[N+1][N+1];
			bfs(p[i].x, p[i].y);
			for(int j=i+1; j<K; j++) {
				if(!check[p[j].x][p[j].y]) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
			
	}
	
	public static void bfs(int x, int y) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		Queue<Pair> q = new LinkedList<Pair>();
		check[x][y] = true;
		q.add(new Pair(x,y));
		
		while(!q.isEmpty()) {
			Pair cur = q.remove();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx <= 0 || ny <=0 || nx >N || ny >N) continue;
				
				if(!visit[cur.x][cur.y][nx][ny] && !check[nx][ny]) {
					check[nx][ny] = true;
					q.add(new Pair(nx,ny));
				}
			}
		}
		
	}
	public static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
