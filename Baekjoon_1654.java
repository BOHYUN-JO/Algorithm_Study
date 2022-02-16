import java.util.*;
import java.io.*;

public class Baekjoon_1654 {
	static int K,N,ans;
	static long Lan[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Lan = new long[K];
		for(int i=0; i<K; i++) {
			Lan[i] = Integer.parseInt(br.readLine()); 
		}
		
		Arrays.sort(Lan);
        
        long right = Lan[K-1]+1;	// +1을 꼭 해줘야 함. 
		long left = 1;
		long mid = 0;
		
		while(left<right) {
			mid = left/2+right/2;	// overflow 방지
			
			long cnt = 0;
			for(int i=0; i<K; i++) {
				cnt += (Lan[i]/mid);
			}
			
			if(cnt < N) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(left-1);
		
	}
	
}
