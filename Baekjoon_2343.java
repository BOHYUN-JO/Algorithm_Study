import java.io.*;
import java.util.*;

public class Baekjoon_2343 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		int tmp = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			tmp = Math.max(tmp, arr[i]);
		}
		
		int left=tmp,mid=sum/2,right=sum;
		while(left <= right) {
			mid = (left+right)/2;
			int ret = check(mid);
			if(ret <= M) {
				ans = Math.min(ans, mid);
				right = mid -1;
			}
			else {
				left = mid +1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int check(int mid) {
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(sum + arr[i] > mid) {
				sum = arr[i];
				cnt++;
			}else {
				sum += arr[i];
			}
		}
		
		cnt++;
		
		return cnt;
	}

}
