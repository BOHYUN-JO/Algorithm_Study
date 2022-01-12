import java.io.*;
import java.util.*;

public class Baekjoon_2206 {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String str= br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		Queue<Tuple> q = new LinkedList<>();
		boolean[][][] visited = new boolean[2][N+1][M+1];
		
		q.add(new Tuple(1,1,1,0));
		visited[0][1][1] = true;
		while(!q.isEmpty()) {
			Tuple cur = q.poll();
			
			if(cur.x == N && cur.y == M) {
				System.out.println(cur.dis);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<1 || ny<1 || nx>N || ny >M) continue;
				
				if(!visited[cur.b][nx][ny] && map[nx][ny] == 0) {
					visited[cur.b][nx][ny] = true;
					q.add(new Tuple(nx,ny,cur.dis+1, cur.b));
				}else if(!visited[cur.b][nx][ny] && map[nx][ny] == 1 && cur.b !=1) {
					visited[1][nx][ny] = true;
					q.add(new Tuple(nx,ny,cur.dis+1, 1));
				}
			}
		}
		
		System.out.println(-1);
		
	}
	
	public static class Tuple{
		int x;
		int y;
		int dis;
		int b;
		Tuple(int x, int y, int dis, int b){
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.b = b;
		}
	}

}
