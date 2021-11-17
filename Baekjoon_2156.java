import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2156 {
	static int N, ans =0;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		if(N>1) dp[2] = arr[2]+arr[1];
		if(N>2) dp[3] = Math.max(arr[1]+arr[2] ,arr[3] + Math.max(arr[1], arr[2]));
		if(N>3) dp[4] = Math.max(arr[4]+arr[3]+arr[1], arr[4]+arr[2]+arr[1]);
		for(int i=5; i<=N; i++) {
			dp[i] = Math.max(arr[i] + dp[i-2], 
					Math.max(arr[i]+arr[i-1]+dp[i-3], 
					Math.max( arr[i]+arr[i-1]+dp[i-4], arr[i-1]+arr[i-2]+dp[i-4] )));	
		}
		
		System.out.println(dp[N]);
		
	}
	
}
