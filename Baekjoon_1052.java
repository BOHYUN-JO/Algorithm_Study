import java.io.*;
import java.util.*;

public class Baekjoon_1052 {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		int ans = 0;
		int cnt = 0;
		while(true) {
			char[] two = Integer.toBinaryString(N).toCharArray();
			cnt = 0;
			
			for(int i=0; i<two.length; i++) {
				if(two[i] == '1') {
					cnt++;
				}
			}
			
			if(cnt <= K) {
				System.out.println(ans);
				break;
			}
			
			N++;
			ans++;
		}
		
	}

}
