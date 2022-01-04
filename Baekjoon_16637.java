import java.io.*;
import java.util.*;

public class Baekjoon_16637 {
	static int N, ans= Integer.MIN_VALUE;
	static String str;
	static ArrayList<Character> op = new ArrayList<>();
	static ArrayList<Integer> digit = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >='0' && ch <='9') {
				digit.add(ch-'0');
			}else {
				op.add(ch);
			}
		}
		dfs(0, digit.get(0));
		
		System.out.println(ans);
	}
	
	public static void dfs(int idx, int cur) {
		if(idx >= op.size()) {
			ans = Math.max(ans, cur);
			return;
		}
		
		dfs(idx+1, cal(cur, digit.get(idx+1), op.get(idx)) );
		
		if(idx+1 < op.size()) {
			int bracket = cal(digit.get(idx+1), digit.get(idx+2), op.get(idx+1));
			dfs(idx+2, cal(cur, bracket, op.get(idx)));
		}
		
	}
	
	public static int cal(int a, int b, char oper)
	{
		int result = a;
		switch (oper){
			case '+': result += b; break;
			case '*': result *= b; break;
			case '-': result -= b; break;
		}
		return result;
	}
	
	
}
