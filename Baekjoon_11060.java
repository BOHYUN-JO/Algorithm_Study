import java.util.*;
import java.io.*;

public class Baekjoon_11060 {
	static int N;
	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 1;
		int cnt = 0;
		boolean flag = false;
		while(idx < N) {
			int max = 0;
			int maxIdx = 0;
			/* ������ �� �ִ� ĭ �� ���� �ָ� �� �� �ִ� ������ ���� */
			for(int i=idx+1; i <= idx+arr[idx]; i++) {
				if(i >= N) {
					flag = true;
					break;
				}
				
				if(max < i+arr[i]) {
					max = i+arr[i];
					maxIdx = i;
				}
			}
			
			/* �� �̻� ������ ���ϸ� -1 */
			if(arr[idx] == 0) {
				cnt = -1;
				break;
			}
			
			cnt++;
			idx = maxIdx;
			if(flag) break;
		}
		System.out.println(cnt);
	}
}
