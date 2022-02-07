import java.io.*;
import java.util.*;

public class Baekjoon_2573 {
	static int N,M;
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(true) {
			visited = new boolean[N][M];
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] < 0) {	// 이미 녹은 빙하 바닷물로 처리
						map[i][j] = 0;
					}
					if(!visited[i][j] && map[i][j] != 0) {
						cnt++;
						bfs(i,j);
						
					}
				}
			}
			//print();
			
			if(cnt >= 2) break;
			if(cnt == 0) {
				ans = 0;
				break;
			}
			ans++;
			
		}
		
		System.out.println(ans);
		
	}
	
	/* 디버깅용 */
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void bfs(int sx,int sy) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx,sy));
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cnt = 0;
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || ny <0 || nx >= N || ny >= M) continue;
				
				if(!visited[nx][ny] && map[nx][ny] != 0) {
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
				}
				
				if(map[nx][ny] == 0) {	// 바닷물 갯수 세기
					cnt++;
				}
			}
			
			/* 빙하 녹이기 */
			map[cur.x][cur.y] -= cnt;
			if(map[cur.x][cur.y] == 0 ) {	// 0이 되면 다른 빙하에 영향을 줄 수 있으므로 -1로 처리
				map[cur.x][cur.y] = -1;
			}
		}
		
		
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
