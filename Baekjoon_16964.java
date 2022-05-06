import java.util.*;
import java.io.*;

public class Baekjoon_16964 {
	static int N,idx=1;
	static int order[];
	static boolean visited[];
	static boolean flag;
	static ArrayList<Integer> tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		order = new int[N];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}
		
		flag = true;
		dfs(1);
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	public static void dfs(int cur) {
		
		if(visited[cur]) return;
		
		visited[cur] = true;
		
		HashSet<Integer> set = new HashSet<>();
		for(int next : tree[cur]) {
			if(!visited[next]) {
				set.add(next);
			}
		}
		
		if(set.size()==0) return;
		
		if(set.contains(order[idx])) {
			dfs(order[idx++]);
		}else {
			flag = false;
		}	
	}
}
