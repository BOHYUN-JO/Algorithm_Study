import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2473 {
	static int N;
	static long max= Long.MAX_VALUE;
	static long arr[];
	static long ans[] = new long[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<N-2; i++) {
			binary(i);
		}
		
		System.out.println(ans[0]+" "+ans[1]+" " +ans[2]);
		
	}
	
	static void binary(int idx) {
		int left = idx+1;
		int right = N-1;
		
		while(left<right) {
			long sum = arr[idx]+arr[left]+arr[right];
			long abs = Math.abs(sum);
			
			if(abs<max) {
				ans[0] = arr[idx];
				ans[1] = arr[left];
				ans[2] = arr[right];
				max = abs;
			}
			
			if(sum > 0) {
				right--;
			}else left++;
		}
	}
}
