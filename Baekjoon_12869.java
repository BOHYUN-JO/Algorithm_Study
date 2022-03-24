import java.util.*;

public class Baekjoon_12869 {
	static int N, ans = Integer.MAX_VALUE;
	static int scv[];
	static int attack[]= {9,3,1};
	static int dp[][][] = new int[61][61][61];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		scv = new int[3];
		for(int i=0; i<N; i++) {
			scv[i] = sc.nextInt();
		}
		
		dfs(scv[0], scv[1], scv[2], 0);
		
		System.out.println(ans);
		
		
	}
	
	public static void dfs(int scv1, int scv2, int scv3, int cnt) {
		
		if(scv1 <=0 && scv2 <=0 && scv3 <=0) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(scv1 < 0 ) scv1 = 0;
		if(scv2 < 0 ) scv2 = 0;
		if(scv3 < 0 ) scv3 = 0;
		
		if(dp[scv1][scv2][scv3] <= cnt && dp[scv1][scv2][scv3] != 0) {
			return;
		}
		
		dp[scv1][scv2][scv3] = cnt;
		
		dfs(scv1-9, scv2-3, scv3-1, cnt+1);
		dfs(scv1-9, scv2-1, scv3-3, cnt+1);
		dfs(scv1-3, scv2-9, scv3-1, cnt+1);
		dfs(scv1-3, scv2-1, scv3-9, cnt+1);
		dfs(scv1-1, scv2-3, scv3-9, cnt+1);
		dfs(scv1-1, scv2-9, scv3-3, cnt+1);
	}
	
}
