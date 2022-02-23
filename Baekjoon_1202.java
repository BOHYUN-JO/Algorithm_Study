import java.io.*;
import java.util.*;

public class Baekjoon_1202 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayList<Gem> gem = new ArrayList<>();
		ArrayList<Integer> bag = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			gem.add(new Gem(m,v));
		}
		for(int i=0; i<K;i++) {
			bag.add(sc.nextInt());
		}
		
		Collections.sort(bag);
		Collections.sort(gem);
		
		long ans = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<K;i++) {
			for(int j=idx; j<N; j++) {
				if(gem.get(j).m <= bag.get(i)) {
					pq.add(gem.get(j).v);	
					idx++;
				}else break;
			}
			
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		
		System.out.println(ans);
		
	}
	
	static class Gem implements Comparable<Gem>{
		int m;	// 보석 무게
		int v;	// 보석 가격
		Gem(int m, int v){
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(Gem o1) {	// 무게순, 그 다음 가치순
			if(this.m != o1.m) {
				return this.m-o1.m;
			}
			return o1.v-this.v;
		}
	}
}
