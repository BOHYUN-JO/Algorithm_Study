import java.util.*;

public class Baekjoon_2230 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		
		int left=0, right=0;
		long min = Integer.MAX_VALUE;
		
		while(left<=right && right < N && left < N) {
			long diff = Math.abs(A[right]-A[left]);
			if(diff>=M && diff<min) {
				min = diff;
				left++;
			}else if(diff < M) {
				right++;
			}else {
				left++;
			}
		}
		System.out.println(min);
	}
}
