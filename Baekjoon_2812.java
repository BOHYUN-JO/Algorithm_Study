import java.io.*;
import java.util.*;

public class Baekjoon_2812 {
	static int N,K;
	static String num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		num = sc.next();
		
		Stack<Character> st = new Stack<>();
		st.add(num.charAt(0));
		int cnt = 0;
		for(int i=1; i<num.length(); i++) {
			char next = num.charAt(i);
			if(cnt == K) {
				for(int j=i; j<num.length(); j++) {
					st.add(num.charAt(j));
				}
				break;
			}
			if(next > st.peek()) {
				while(cnt < K) {
					if(!st.isEmpty() && next > st.peek()) {
						st.pop();
						cnt++;
					}else break;
				}
				st.add(next);
			}else {
				st.add(next);
			}
		}
		if(cnt <K) {
			for(; cnt<K; cnt++) {
				st.pop();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		System.out.println(sb.reverse());
		
		
	}

}
