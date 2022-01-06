import java.io.*;
import java.util.*;

public class Baekjoon_1747 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans= N;
		while(true) {
			if(isPrime(ans) && isPalindrom(ans)) {
				break;
			}
			ans++;
		}

		System.out.println(ans);
	}

	public static boolean isPrime(int num) {
		int half = (int) Math.sqrt(num);
		
		if(num < 2) return false;
		if(num == 2) return true;
		
		for(int i=2; i<=half; i++) {
			if(num%i ==0 )return false;
		}
		
		return true;
	}
	
	public static boolean isPalindrom(int num) {
		String str = String.valueOf(num);
		int len = str.length()/2;
		for(int i=0; i<len; i++) {
			if(str.charAt(i)!= str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}
