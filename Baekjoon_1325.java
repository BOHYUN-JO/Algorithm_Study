import java.io.*;
import java.util.*;

public class Baekjoon_1325 {
	static int N,M;
	static List<Integer>[] list;
	static boolean[] visited ;
	static int[] ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, ans[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=1; i<=N; i++) {
			if(max == ans[i]) {
				sb.append(i+ " ");
			}
		}
		System.out.println(sb.toString().trim());
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : list[cur]) {
				if(!visited[next]) {
					ans[next]++;
					visited[next] = true;
					q.add(next);
				}
			}
		}
	}

}
