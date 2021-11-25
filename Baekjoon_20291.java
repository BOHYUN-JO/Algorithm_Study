import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_20291 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> ans = new TreeMap<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			String temp = st.nextToken();
			String extend = st.nextToken();
			ans.compute(extend, (k,v) -> (v==null)? 1 : v+1);
		}
		
		for(Map.Entry<String, Integer> entry : ans.entrySet() ) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key +" " + value);
		}
		
	}

}
