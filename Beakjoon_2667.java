import java.io.*;
import java.util.*;

public class Beakjoon_2667 {
	static int N;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char map[][];
	static boolean visited[][];
	static ArrayList<Integer> ans = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == '1') {
					bfs(i,j);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
	public static void bfs(int sx, int sy) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx,sy));
		visited[sx][sy] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx <0 || ny <0 || nx >=N || ny >=N) continue;
				
				if(!visited[nx][ny] && map[nx][ny] == '1') {
					q.add(new Point(nx,ny));
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		ans.add(cnt);
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
