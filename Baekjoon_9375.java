import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_9375 {
	static int T;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			
			HashMap<String, Integer> map = new HashMap<>();
			for(int i=0; i<N; i++) {
				 StringTokenizer st = new StringTokenizer(br.readLine());
				 st.nextToken();
				 String key = st.nextToken();
				 map.compute(key, (k,v)-> (v==null ? 1 : v+1) );
			}
			
			for(String key : map.keySet()) {
				ans *= (map.get(key)+1);
			}
			ans--;
			System.out.println(ans);
		}
	}
	
}
