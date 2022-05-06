import java.util.*;
import java.io.*;

public class Baekjoon_10971 {
	static int W[][];
	static int N, min=Integer.MAX_VALUE;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[1] = true;
		
		dfs(1,0,1);
		
		System.out.println(min);
	}
	public static void dfs(int cur, int cost, int cnt) {
		
		if(cnt == N ) {
			if(W[cur][1] != 0) {
				min = Math.min(cost+W[cur][1], min);
			}
			
			return;
		}
		
		if(cost>min) {
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if( !visited[i] && W[cur][i] != 0 ) {
				visited[i] = true;
				dfs(i, cost+W[cur][i], cnt+1);
				visited[i] = false;
			}
		}
	}

}
