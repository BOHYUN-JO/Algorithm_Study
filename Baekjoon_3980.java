import java.io.*;
import java.util.*;

public class Baekjoon_3980 {
	static int C, ans;
	static int arr[][] = new int[12][12];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		
		while(C-- > 0) {
			ans = 0;
			visited = new boolean[12];
			for(int i=1; i<=11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1; j<=11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(1, 0);
			System.out.println(ans);
		}

	}
	
	public static void dfs(int depth, int sum) {
		
		if(depth > 11) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=1; i<=11; i++) {
			if(arr[depth][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(depth+1, sum+arr[depth][i]);
				visited[i] = false;
			}
		}
		
	}

}
