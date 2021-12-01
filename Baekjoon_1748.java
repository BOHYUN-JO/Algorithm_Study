import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1748 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int digit = (int)(Math.log10(N)+1);	// ÀÚ¸´¼ö
		int ans = 0;
		int left = 1;
		int right = 9;
		while(left <digit) {
			ans += left*right;
			left++;
			right *= 10;
		}
		
		ans += digit* (N-Math.pow(10, digit-1)+1);
		
		System.out.println(ans);

	}

}
