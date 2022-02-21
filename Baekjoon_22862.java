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
		int cnt = arr[0]%2!=0 ? 1 : 0;	// ù��° ���Ұ� Ȧ���� 1 �ƴϸ� 0
		int ans = 0;
		
		while(left < N && right <N) {
			boolean indexFlag = false;
			
			/* Ȧ�� ������ K���� ���� ������ ������ ������ �̵� */
			while(cnt <= K) {
				right++;
				if(right >=N) {	// right �����Ͱ� ������ ������
					indexFlag = true;
					break;
				}
				/* Ȧ�� ���� count */
				if(arr[right] %2 != 0) {
					cnt++;
				}
			}
			
			/* ������ ���� �ʾҴٸ� K���� �ѱ� ���� �ε����� �ű� */
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
