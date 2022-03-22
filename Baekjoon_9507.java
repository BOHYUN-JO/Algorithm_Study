import java.io.*;
import java.util.Scanner;

public class Baekjoon_9507 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long dp[] = new long[70]; 
		dp[0]=dp[1]=1;
		dp[2] = 2; dp[3] = 4;
		
		for(int i=4; i<70; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
		}
		
		
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int num = sc.nextInt();
			System.out.println(dp[num]);
		}
	}
}
