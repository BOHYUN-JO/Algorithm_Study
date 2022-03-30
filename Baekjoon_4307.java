import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_4307 {
	static int T,l,n;
	static boolean ant[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			ant = new boolean[l+1];
			for(int i=0; i<n; i++) {
				ant[Integer.parseInt(br.readLine())] = true;
			}
			
			int left=l/2,right=l/2;
			while(left>0) {
				if(ant[left]) break;
				left--;
			}
			while(right<l) {
				if(ant[right]) break;
				right++;
			}
			System.out.print(Math.max(left, l-right)+" ");
			left=0; right = l;
			while(left<l) {
				if(ant[left]) break;
				left++;
			}
			while(right>0) {
				if(ant[right]) break;
				right--;
			}
			System.out.println(Math.max(l-left, right));
		}
	}
}
