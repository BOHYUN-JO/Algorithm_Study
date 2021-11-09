import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2252 {
	static int N,M;
	static ArrayList<Integer>[] adj;
	static int[] inDegree;
	static LinkedList<Integer> q;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		inDegree = new int[N+1];
		q= new LinkedList<Integer>();
		ans = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			inDegree[b]++;
		}
		
		for(int i=1; i<=N; i++) {
			if(inDegree[i] ==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			for(int i=0; i<adj[cur].size(); i++) {
				int next = adj[cur].get(i);
				inDegree[next]--;
				if(inDegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}

	}

}
