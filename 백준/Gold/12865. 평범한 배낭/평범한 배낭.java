import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static int dp[][], w[], v[];
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int[N+1][K+1];
		w = new int[N+1];
		v = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			w[i]= sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j]; 
				if(j - w[i]>=0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]); 
				}
			}
		}
		
		System.out.println(dp[N][K]);

	}
	
}
