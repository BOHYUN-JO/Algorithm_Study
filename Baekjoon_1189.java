import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1189 {
	private static int[] my = {-1,1,0,0};
	private static int[] mx = {0,0,-1,1};
	private static boolean[][] visited; 
	private static int R, C, K, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		
		char[][] arr = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String temp = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		
		visited[R-1][0] = true;
		dfs(arr,R-1,0,1);
	
		System.out.println(ans);
		
	}
	
	public static void dfs(char[][] arr, int y, int x, int cnt) {
		if(cnt > K) return;
		
		if(y == 0 && x == C-1 && cnt == K) {
			ans++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];
			if(ny <  0 || nx < 0 || ny >=R || nx >= C) continue;
			if(!visited[ny][nx] && arr[ny][nx] != 'T') {
				visited[ny][nx] = true;
				dfs(arr, ny,nx, cnt+1);
				visited[ny][nx] = false;
			}
		}
	}
}
