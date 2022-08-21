import java.util.*;
import java.lang.*;
import java.io.*;


class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int N = sc.nextInt();
		int[] dp = new int[C+101];
		
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		
		for(int i=0; i<N; i++){
			int cost = sc.nextInt();
			int get= sc.nextInt();
			for(int j = get; j<C+101; j++ ){
				dp[j] = Math.min(dp[j], dp[j-get] + cost);
			}
		}
		
		
		int ans = Integer.MAX_VALUE;
		for(int i=C; i<C+101; i++){
			ans = Math.min(ans, dp[i]);
		}
		
		System.out.println(ans);
		
		
	}
}