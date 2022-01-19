import java.io.*;
import java.util.*;

public class Baekjoon_12865 {
	static int N,K;
	static int dp[][], w[], v[];
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int[N+1][K+1];
		w = new int[N+1];	// 무게 저장
		v = new int[N+1];	// 가치 저장
		
		for(int i=0; i<N; i++) {
			w[i]= sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j]; 	// 이전 행 결과 복사
				if(j - w[i]>=0) {	// 무게가 남으면
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]); // 더 큰 값으로 갱신
				}
			}
		}
		
		System.out.println(dp[N][K]);

	}
	
}
