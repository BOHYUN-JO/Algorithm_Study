import java.io.*;
import java.util.*;

public class Baekjoon_16637 {
	static int N;
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
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
