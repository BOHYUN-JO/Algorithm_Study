import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1967 {
	static int N, ans;
	static ArrayList<Pair> tree[];
	static boolean visited[];
	static ArrayList<Integer> leaf = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tree[a].add(new Pair(b,c));
			tree[b].add(new Pair(a,c));
		}
		for(int i=2; i<=N; i++) {
			if(tree[i].size() <2) {
				leaf.add(i);
				//System.out.println(i);
			}
		}
		
		for(int i=0; i<leaf.size(); i++) {
			dfs(leaf.get(i), 0);
		}
		
		System.out.println(ans);
		
	}
	private static void dfs(int idx, int sum) {
		visited[idx] = true;
		
		if(ans < sum) {
			ans =sum ;
		}
		
		for(int i=0; i<tree[idx].size(); i++) {
			
			int next = tree[idx].get(i).link;
			
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, sum+tree[idx].get(i).w);
				visited[next] = false;
			}	
		}
		visited[idx] = false;
	}
	
	static class Pair{
		int link;
		int w;
		Pair(int a, int b){
			this.link = a;
			this.w = b;
		}
	}

}
