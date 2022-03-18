import java.io.*;
import java.util.*;

public class Baekjoon_21939 {
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		TreeSet<Problem> minHeap = new TreeSet<>();
		HashMap<Integer, Integer> dict = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			minHeap.add(new Problem(P,L));
			dict.put(P, L);
		}
		
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					System.out.println(minHeap.last().p);
				}else {
					System.out.println(minHeap.first().p);
				}
			}else if(cmd.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				minHeap.add(new Problem(p,l));
				dict.put(p, l);
			}else {
				int p = Integer.parseInt(st.nextToken());
				minHeap.remove(new Problem(p, dict.get(p)));
				dict.remove(p);
			}
		}
		

	}
	
	public static class Problem implements Comparable<Problem>{
		int p;
		int l;
		Problem(int p, int l){
			this.p = p;
			this.l = l;
		}
		
		@Override
		public int compareTo(Problem other) {
			if(this.l == other.l) {
				return this.p - other.p;
			}
			return this.l - other.l;
		}
	}

}
