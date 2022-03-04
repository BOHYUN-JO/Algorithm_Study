import java.io.*;
import java.util.*;

public class Baekjoon_2146 {
	static int N,ans=Integer.MAX_VALUE;
	static int map[][];
	static ArrayList<Point> edges = new ArrayList<>();
	static boolean visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int num = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					findIsland(i,j,num++);
				}
			}
		}
		
		for(Point edge : edges ) {
			findBridge(edge.x,edge.y,map[edge.x][edge.y]);
		}
		
		System.out.println(ans);
	}
	
	/* 섬을 모두 찾고, 가장자리를 찾는 함수 */
	public static void findIsland(int x, int y, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			map[cur.x][cur.y] = num;	// 섬의 숫자를 1,2,3....으로 변경
			boolean flag = false;
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny <0 || nx >=N || ny >=N) continue;
				
				/* 가장자리 추가 */
				if(!flag && map[nx][ny] == 0) {
					edges.add(cur);
					flag = true;
				}
				
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny,0));
				}
			}
		}
	}
	
	/* 최단거리 다리 구하기 */
	public static void findBridge(int x, int y, int num) {
		visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(cur.cnt >= ans) return; 
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny <0 || nx >=N || ny >=N) continue;
				
				/* 다른 섬의 가장자리를 만난다면 */
				if(map[nx][ny] != num && map[nx][ny] != 0) {
					ans = Math.min(ans, cur.cnt);
					return;
				}
				
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny, cur.cnt+1));
				}
			}
		}
	}
		
	static class Point{
		int x;
		int y;
		int cnt;
		Point(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}
