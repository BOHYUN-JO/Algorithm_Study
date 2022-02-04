import java.io.*;
import java.util.*;

public class Baekjoon_19583 {
	static String S,E,Q;
	static int s,e,q, ans;
	static HashSet<String> before = new HashSet<>();
	static HashSet<String> answer = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = st.nextToken();
		E = st.nextToken();
		Q = st.nextToken();
		
		s = time2int(S);
		e = time2int(E);
		q = time2int(Q);
		
		String input = "";
		while( (input = br.readLine()) != null ) {
			st = new StringTokenizer(input);
			int time = time2int(st.nextToken());
			String name = st.nextToken();
			if(time <= s) {
				if(!before.contains(name)) {
					before.add(name);
				}
			}else if(time >= e && time <= q) {
				if(before.contains(name)) {
					answer.add(name);
				}
			}
			
		}
		
		System.out.println(answer.size());		
	}
	
	static int time2int(String str) {
		String[] temp = str.split(":");
		int hour = Integer.parseInt(temp[0]) *60;
		
		return hour + Integer.parseInt(temp[1]);
	}

}
