import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1918 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< len; i++) {
			int p = priority(str.charAt(i));
			char ch = str.charAt(i);
			
			switch(ch) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!st.empty() && priority(st.peek()) >= p ) {
					sb.append(st.pop());
				}
				st.push(ch);
				break;
			
			case '(':
				st.push(ch);
				break;
			case ')':
				while(!st.empty() &&st.peek() != '(') {
					sb.append(st.pop());
				}
				st.pop();
				break;
			default :
				sb.append(ch);
			}
		}
		
		while(!st.empty()) {
			sb.append(st.pop());
		}
		
		System.out.println(sb.toString());

	}
	
	public static int priority(char ch) {
		switch(ch) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		case '(':
		case ')':
			return 0;
		}
		
		return -1;
	}

}
