import java.io.*;
import java.util.*;

public class Baekjoon_2470 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int diff = Integer.MAX_VALUE;
		int left = 0;
		int right = N-1;
		
		int ans1 = 0;
		int	ans2 = 0;
		while(left<right) {
			int tDiff = arr[right]+arr[left];
			
			if(Math.abs(tDiff) < diff) {
				ans1= arr[left];
				ans2 = arr[right];
				diff = Math.abs(tDiff);
			}
			
			if(tDiff > 0) {
				right--;
			}else {
				left++;
			}
		}
		
		System.out.println(ans1 +" " + ans2);
		
	}

}
