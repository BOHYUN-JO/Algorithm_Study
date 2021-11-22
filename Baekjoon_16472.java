import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_16472 {
	static int N, ans=0;
	static String str;
	static int[] check = new int[26];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		if(N>= str.length() ) {
			System.out.println(str.length());
			return;
		}
		
		int left = 0;
		int right = 0;
		int cnt = 0;
		
		check[str.charAt(0)-'a']++;
		cnt++;
		
		while(true) {
			right++;
			
			if(right == str.length()) break;
			
			int num = str.charAt(right) - 'a';
			check[num]++;
			
			if(check[num] == 1) {
				cnt++;
			}
			
			while(cnt > N) {
				int num2 = str.charAt(left) - 'a';
				check[num2]--;
				
				if(check[num2] ==0) {
					cnt--;
				}
				left++;
			}
			ans = Math.max(ans, right-left+1);
			
		}
		
		System.out.println(ans);

	}

}
