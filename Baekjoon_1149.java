import java.io.*;
import java.util.Scanner;

public class Baekjoon_1149 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int color[][] = new int[N+1][3];
		int dp[][] = new int[N+1][3];
		int ans = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			color[i][0] = sc.nextInt();
			color[i][1] = sc.nextInt();
			color[i][2] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				int min = Integer.MAX_VALUE;
				for(int k=0; k<3; k++) {
					if(j==k) continue; 	// °°Àº »ö 
					min = Math.min(min, dp[i-1][k]);
				}
				dp[i][j] = min + color[i][j];
			}
		}
		
		for(int i=0; i<3; i++) {
			ans = Math.min(ans, dp[N][i]);
		}
		System.out.println(ans);
	}
}
