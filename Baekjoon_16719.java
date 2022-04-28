import java.io.*;
import java.util.*;

public class Baekjoon_16719 {
	static String str;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		visited = new boolean[str.length()];
		dfs(0, str.length()-1);
	}
	
	public static void dfs(int left, int right) {
		if(left > right) return;
		
		int idx = left;
		
		for(int i=left; i<=right; i++) {
			if(str.charAt(idx) > str.charAt(i)) {
				idx = i;
			}
		}
		
		visited[idx] = true;
		
		for(int i=0; i<str.length(); i++) {
			if(visited[i]) {
				System.out.print(str.charAt(i));
			}
		}
		
		System.out.println();
		
		dfs(idx+1, right);
		dfs(left, idx-1);
	}
}
