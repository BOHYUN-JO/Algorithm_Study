import java.io.*;
import java.util.*;

public class Baekjoon_2109 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>( (o1,o2) -> o2.p-o1.p );
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			pq.add(new Pair(p,d));
		}
		
		HashMap<Integer, Integer> time = new HashMap<>();
		while(!pq.isEmpty()) {
			int p = pq.peek().p;
			int d = pq.peek().d;
			pq.poll();
			for(int i=d; i>0; i--) {
				if(time.containsKey(i)) {
					continue;
				}else {
					time.put(i, p);
					break;
				}
			}
			
		}
		for(Integer key : time.keySet()) {
			ans += time.get(key);
		}
		
		System.out.println(ans);
		
	}
	public static class Pair{
		public int p;
		public int d;
		Pair(int p,int d){
			this.p = p;
			this.d = d;
		}
		
	}

}
