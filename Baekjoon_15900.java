import java.io.*;
import java.util.*;

public class Baekjoon_15900 {
	static int N, ans=0;
	static ArrayList<Integer> tree[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		boolean visited[] = new boolean[N+1];
		visited[1] = true;
		
		dfs(1,visited,0);
		if(ans %2 == 0) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
				
	}
	
	static void dfs(int n, boolean visited[], int cnt) {
		if(tree[n].size() == 1 && n != 1) {	// 리프노드를 만나면
			ans += cnt;
			return;
		}
		for(int i=0; i<tree[n].size(); i++) {
			int next = tree[n].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, visited, cnt+1);
				visited[next] = false;
			}
		}
	}
}
