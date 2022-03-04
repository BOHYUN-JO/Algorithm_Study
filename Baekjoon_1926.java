import java.io.*;
import java.util.*;

public class Baekjoon_1926 {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					count++;
					ans = Math.max(ans,bfs(i,j));
				}
			}
		}
		
		System.out.println(count);
		System.out.println(ans);
	}
	
	public static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		int cnt = 1;
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx <0 || ny <0 || nx >=N || ny >=M ) continue;
				
				if(!visited[nx][ny] && arr[nx][ny] ==1) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny));
					cnt++;
				}
			}
		}
		
		return cnt;
		
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
