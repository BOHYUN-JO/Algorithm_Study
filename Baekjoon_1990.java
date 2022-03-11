import java.io.*;
import java.util.*;

public class Baekjoon_1990 {
	static boolean prime[] = new boolean[100000001];
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		StringBuilder sb = new StringBuilder();
		
		/* i*i<b 라고 했다가 엄청 틀렸음..ㅠㅠ i*i<=b 가 맞다 */
		for(int i=2; i*i<=b; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=b; j+=i ) {
					prime[j] = true;
				}
			}
		}
		
		
		for(int i=a; i<=b; i++) {
			if(!prime[i] && isPalindrome(i)) {
				sb.append(i).append("\n");
			}
		}
		sb.append(-1);
		System.out.println(sb);
	}

	public static boolean isPalindrome(int num) {
		String str = String.valueOf(num);
		
		for(int i=0; i< str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		
		return true;
	}
}
