import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1806 {
	static int N,S, ans = Integer.MAX_VALUE;
	static int[] seq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		seq = new int[N+1];
		st =  new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 1;
		long sum = seq[0]+seq[1];
		while(true) {
			if(sum >= S) {
				if(right-left+1 <ans) {
					ans = right-left+1;
					if(ans ==1) break;
				}
				sum -= seq[left];
				left++;
				if(left>=N || right >=N) break;
			}else {
				right++;
				if(left>=N || right >=N) break;
				sum += seq[right];
			}	
		}
		
		if(ans == Integer.MAX_VALUE) {
			ans = 0;
		}
		
		System.out.println(ans);

	}

}
