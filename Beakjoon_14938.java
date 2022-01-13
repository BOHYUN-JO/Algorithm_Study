import java.io.*;
import java.util.*;

public class Beakjoon_14938 {
	static int n,m,r, ans = Integer.MIN_VALUE;
	static int[] itemCnt;
	static ArrayList<Pair>[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		itemCnt = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n ; i++) {
			itemCnt[i] = Integer.parseInt(st.nextToken());
			map[i] = new ArrayList<>();
		}
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map[a].add(new Pair(b,w));
			map[b].add(new Pair(a,w));
		}
		
		for(int i=1; i<=n; i++) {
			bfs(i);
		}
		
		System.out.println(ans);

	}
	
	static void bfs(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
		boolean[] check = new boolean[n+1];
		int ret = 0;
		int[] dist = new int[n+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(check, false);
		
		pq.add(new Pair(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			int pos = cur.next;
			
			if(!check[pos]) {
				check[pos] = true;
				
				for(Pair p : map[pos]) {
					if(!check[p.next] && dist[p.next] > dist[pos] + p.w) {
						dist[p.next] = dist[pos] + p.w;
						pq.add(new Pair(p.next, dist[p.next]));
					}
				}
			}
			
		}
		
		for(int i=1; i<=n; i++) {
			if(dist[i] <=m) {
				ret += itemCnt[i];
			}
		}
		
		ans = Math.max(ans, ret);
		
	}
	
	static class Pair{
		int next;
		int w;
		Pair(int x, int y){
			this.next = x;
			this.w = y;
		}
	}

}
