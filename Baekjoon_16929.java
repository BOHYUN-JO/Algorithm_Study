import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_16929 {
	static int N,M;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<N;k++) {
					Arrays.fill(visited[k], false);
				}
				dfs(0, i,j, i,j, arr[i][j]);
				
			}
		}
		
		if(ans) {
			System.out.println("Yes");
		}else System.out.println("No");

	}
	
	private static void dfs(int depth, int x, int y, int sx, int sy, char prev) {
		
		visited[x][y] = true;
		
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
			
			if(depth>1 && nx == sx && ny == sy) {
				ans = true;
				return;
			}
			
			if(!visited[nx][ny] && arr[nx][ny] == prev) {
				dfs(depth+1, nx,ny, sx,sy, prev);
			}
		}
		
		
	}

}
