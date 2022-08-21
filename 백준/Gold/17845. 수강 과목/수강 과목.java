import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] I = new int[K+1];
		int[] T = new int[K+1];
		int[][] dp = new int[K+1][N+1];
		
		
		for(int i=1; i<=K; i++){
			I[i] = sc.nextInt();
			T[i] = sc.nextInt();
		}
        
        for(int i=0; i<=K; i++){
            for(int j=0; j<=N; j++){
                dp[i][j] = 0;
            }
        }
		
		for(int i=1; i<=K; i++){
			for(int j=1; j<=N; j++){
				dp[i][j] = dp[i-1][j];
				if(j - T[i] >=0){
					dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-T[i]] + I[i]);
				}
			}
		}
		
		System.out.println(dp[K][N]);
		
		
	}
}