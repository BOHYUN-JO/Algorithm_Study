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
		
		List<Long> plus = new ArrayList<>();
		List<Long> minus = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			long num = Long.parseLong(st.nextToken());
			if(num >=0) {
				plus.add(num);
			}else {
				minus.add(Math.abs(num));
			}
		}
		
		Collections.sort(plus);
		Collections.sort(minus);
		
		int idx = 0;
		int cnt = 0;
		for(long num : plus) {
			if(idx == plus.size()-1) {
				ans += num*2;
				break;
			}
			cnt++;
			if(cnt == k) {
				cnt = 0;
				ans += num*2;
			}
			idx++;
		}
		
		idx = 0; 
		for(long num : minus) {
			if(idx == minus.size()-1) {
				ans += num*2;
				break;
			}
			cnt++;
			if(cnt == k) {
				cnt = 0;
				ans += num*2;
			}
			idx++;
		}
		
		System.out.println(ans);
	}

}