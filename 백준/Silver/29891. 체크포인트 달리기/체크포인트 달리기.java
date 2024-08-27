import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long ans = 0;
		
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num >=0) {
				plus.add(num);
			}else {
				minus.add(Math.abs(num));
			}
		}
		
		int cnt = 0;
		while(!plus.isEmpty()) {
			ans += plus.peek()*2;
			cnt = k;
			
			while(!plus.isEmpty() && cnt-- >0) {
				plus.poll();
			}
		}
		
		while(!minus.isEmpty()) {
			ans += minus.peek()*2;
			cnt = k;
			
			while(!minus.isEmpty() && cnt-- >0) {
				minus.poll();
			}
		}
		
		
		System.out.println(ans);
	}

}