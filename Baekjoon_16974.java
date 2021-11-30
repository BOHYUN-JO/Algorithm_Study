import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_16974 {
	static long[] h, p;
	static int N;
	static long X;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		h = new long[N + 1];
		p = new long[N + 1];
		
		h[0] = 1;
		p[0] = 1;
		
		for(int i = 1 ; i <= N ; ++i) {
			h[i] = 1 + h[i - 1] + 1 + h[i - 1] + 1;
			p[i] = p[i - 1] + 1 + p[i - 1];
		}
		
		System.out.println(solve(N, X));

	}
private static long solve(int n, long x) {
		
		if (n == 0) {
			if (x == 0) return 0;
			else if (x == 1) return 1;
		}
		
		if(x == 1) {
			return 0;
		} else if(x <= 1 + h[n - 1]) {
			return solve(n - 1, x - 1);
		} else if(x == 1 + h[n - 1] + 1) {
			return p[n - 1] + 1;
		} else if(x <= 1 + h[n - 1] + 1 + h[n - 1]) {
			return p[n - 1] + 1 + solve(n - 1, x - (1 + h[n - 1] + 1));
		} else {
			return p[n - 1] + 1 + p[n - 1];
		}
	}
	
	

}
