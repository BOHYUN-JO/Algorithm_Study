import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_10653 {
	static int N,K;
	static Pair p[];
	static int dis[][];
	static int dp[][];
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		p = new Pair[N+1];
		dp = new int[N+1][K+1];
		dis = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				dis[i][j] = getDistance(p[i].x,p[i].y,p[j].x, p[j].y);
			}
		}
		
		
		System.out.println(getDp(N,K));

	}
	
	private static int getDistance(int x1,int y1,int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	private static int getDp(int n, int k) {
		if(dp[n][k] != -1) {
			return dp[n][k];
		}
		
		if(n==1) return 0;
		int ans = Integer.MAX_VALUE;
		for(int i=0; i<=k ; i++) {
			if(n-1-i > 0) {
				ans = Math.min(ans,  getDp(n-1-i,k-i)+dis[n-1-i][n]);
			}
		}
		return dp[n][k] = ans;
	}
	
	private static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
