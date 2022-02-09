import java.io.*;
import java.util.*;

public class Baekjoon_20365 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
				 
		int rCnt = count('R', str);
		int bCnt = count('B', str);
		
		System.out.println(Math.min(rCnt, bCnt)+1);
	}
	
	static int count(char ch, String str) {
		int cnt = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				while(true) {
					i++;
					if(i>= str.length() || str.charAt(i) != ch) break;
				}
				cnt++;
			}
		}
		return cnt;
	}
}
