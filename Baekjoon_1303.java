import java.util.*;
import java.io.*;

public class Baekjoon_1303 {
	static int blue, white, N, M;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char arr[][];
	static boolean visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i,j, arr[i][j]);
				}
			}
		}
		
		System.out.println(white +" " + blue);
	}
	
	public static void bfs(int x, int y, char start) {
		int cnt = 1;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx <0 || ny<0 || nx>=M || ny>= N) continue;
				
				if(!visited[nx][ny] && arr[nx][ny] == start) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny));
					cnt++;
				}
			}
		}
		
		if(start == 'W') {
			white += cnt*cnt;
		}else {
			blue += cnt*cnt;
		}
	}
	
	public static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
