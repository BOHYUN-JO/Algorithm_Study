import java.io.*;
import java.util.*;

public class Baekjoon_7570 {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int k = Integer.parseInt(st.nextToken());
			dp[k] = dp[k-1] +1;
			ans = Math.max(dp[k], ans);
		}
		
		System.out.println(N-ans);
	}

}
