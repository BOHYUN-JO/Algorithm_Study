import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_12919 {
	static boolean flag =false;
	public static void main(String[] args) throws Exception {
		String S ,T ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S=(br.readLine());
		T=(br.readLine());
		dfs(S,T);
		if(flag) {
			System.out.print(1);
		}else System.out.print(0);
	}
	
	private static void dfs(String S, String T) {
		
		if(S.length() == T.length()) {
			if(S.equals(T)) {
				flag = true;
				return;
			}
			return;
		}
		
		if(T.charAt(T.length()-1) == 'A') {
			dfs(S, T.substring(0, T.length()-1));
		}
		if(T.charAt(0) == 'B') {
			StringBuffer sb = new StringBuffer(T.substring(1, T.length()));
			dfs(S, sb.reverse().toString());
		}
	}
	

}
