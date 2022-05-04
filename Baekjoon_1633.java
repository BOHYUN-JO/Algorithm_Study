import java.util.*;

public class Baekjoon_1633 {
	static int white[] = new int[1001];
	static int black[] = new int[1001];
	static int dp[][][] = new int[1001][16][16];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = 0;
		while(sc.hasNextInt()) {
			 white[idx]= sc.nextInt();
			 black[idx++] = sc.nextInt();
		}
		
		System.out.println(dfs(0,0,0,idx));
	}
	
	public static int dfs(int depth, int wCnt, int bCnt, int N) {
		if(depth >= N) {
			return 0;
		}else if(wCnt == 15 && bCnt == 15) return 0;
		
		if(dp[depth][wCnt][bCnt] != 0) return dp[depth][wCnt][bCnt];
		
		int ans = dfs(depth+1, wCnt, bCnt, N);
		
		if(wCnt <15) {
			ans = Math.max(ans, dfs(depth+1, wCnt+1, bCnt, N)+white[depth]);
		}
		if(bCnt < 15) {
			ans = Math.max(ans,dfs(depth+1, wCnt, bCnt+1, N)+black[depth]);
		}
		
		dp[depth][wCnt][bCnt] = ans;
		
		return ans;
		
	}

}
