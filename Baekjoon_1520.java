import java.io.*;
import java.util.*;

public class Baekjoon_1520 {
	static int N,M;
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	static int dfs(int x, int y) {
		
		if(x == N-1 && y == M-1) return 1;	// 오른쪽 아래 도달
		
		if(dp[x][y] != -1) return dp[x][y];	// 이미 경로를 구했다면 반환
		
		dp[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx <0 || ny<0 || nx>=N  || ny >= M) continue;
			
			if(map[nx][ny] < map[x][y]) {
				dp[x][y] += dfs(nx,ny);
			}
		}
		
		return dp[x][y];
	}

}
