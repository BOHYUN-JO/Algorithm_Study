import java.util.*;

public class Baekjoon_2482 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int dp[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}
		
		for(int i=3; i<=N; i++) {
			for(int j=2; j<=(i+1)/2; j++){
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % 1000000003;
			}
		}
		
		System.out.println( (dp[N-3][K-1] + dp[N-1][K]) %1000000003 );
		

	}

}
