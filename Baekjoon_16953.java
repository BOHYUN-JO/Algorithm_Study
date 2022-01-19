import java.io.*;
import java.util.*;

public class Baekjoon_16953 {
	static long A,B, ans;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		dfs(A, 1);
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}
	
	public static void dfs(long num, int cnt) {
		if(num > B) return;
		if(num == B) {
			ans = cnt;
			flag = true;
			return;
		}
		
		dfs(num*2, cnt+1);
		dfs(num*10+1, cnt+1);
	}
}
