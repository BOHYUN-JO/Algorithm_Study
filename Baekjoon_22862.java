import java.util.*;
import java.io.*;

public class Baekjoon_22862 {
	static int N,K;
	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left=0, right = 0;
		int cnt = arr[0]%2!=0 ? 1 : 0;	// 첫번째 원소가 홀수면 1 아니면 0
		int ans = 0;
		
		while(left < N && right <N) {
			boolean indexFlag = false;
			
			/* 홀수 개수가 K개를 넘을 때까지 오른쪽 포인터 이동 */
			while(cnt <= K) {
				right++;
				if(right >=N) {	// right 포인터가 범위를 넘으면
					indexFlag = true;
					break;
				}
				/* 홀수 갯수 count */
				if(arr[right] %2 != 0) {
					cnt++;
				}
			}
			
			/* 범위를 넘지 않았다면 K개를 넘기 직전 인덱스로 옮김 */
			if(!indexFlag) {
				cnt--;
			}
			right--;
			
			ans = Math.max(ans, right-left+1-cnt);
			
			if(arr[left] %2 != 0) {
				cnt--;
			}
			left++;
		}
		
		System.out.println(ans);
		
	}

}
