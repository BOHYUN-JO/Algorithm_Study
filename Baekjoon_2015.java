import java.util.*;
import java.io.*;

public class Baekjoon_2015 {
	static int N,K;
	static int arr[];
	static int preSum[];
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		preSum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		Map<Integer, Long> map = new HashMap<>();
		
		long ans = 0;
		for(int i=1; i<=N; i++) {
			preSum[i] = Integer.parseInt(st.nextToken()) + preSum[i-1];
			
			if(preSum[i] == K) ans++;
			
			if(map.containsKey(preSum[i] - K)) {
				ans += map.get(preSum[i] - K);
			}
			
			map.compute(preSum[i], (k,v) -> v==null ? 1L : v+1 );
		}
		
		System.out.println(ans);
	}

}
