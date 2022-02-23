import java.io.*;
import java.util.*;

public class Baekjoon_1012 {
	static int T,N,M,K,ans;
	static int arr[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			ans = 0;
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			boolean visited[][] = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						bfs(i,j,visited);
					}
				}
			}
			System.out.println(ans);
		}

	}
	
	static void bfs(int x, int y, boolean visited[][]) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || ny <0 || nx >=N || ny >= M) continue;
				
				if(!visited[nx][ny] && arr[nx][ny] == 1) {
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		ans++;
	}
	
	static class Point{
		int x;
		int y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

}
