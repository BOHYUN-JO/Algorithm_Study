import java.io.*;
import java.util.*;

public class Baekjoon_1713 {
	
	public static void main(String[] args) throws Exception{
		int N, total;
		TreeMap<Integer, Pair> m = new TreeMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		total = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<total; i++) {
			int like = Integer.parseInt(st.nextToken());
			if(m.size() < N) {
				m.compute(like, (k,v) -> (v==null) ? new Pair(1,1) : new Pair(v.like+1, v.age) );
			}else {
				if(m.containsKey(like)) {
					m.put(like, new Pair(m.get(like).like+1, m.get(like).age) );
					continue;
				}
				int minLike = Integer.MAX_VALUE;
				int maxAge = Integer.MIN_VALUE;
				int idx=0;
				for(Integer key : m.keySet()) {
					Pair tmp = m.get(key);
					if(tmp.like < minLike) {
						idx = key;
						minLike = tmp.like;
						maxAge = tmp.age;
					}else if(tmp.like == minLike) {
						if(tmp.age > maxAge) {
							idx = key;
							maxAge = tmp.age;
							minLike = tmp.like;
						}
					}
				}
				m.remove(idx);
				m.put(like, new Pair(1,1));
			}
			
			for(Integer key : m.keySet()) {
				//System.out.print(key +" ");
				m.put(key, new Pair(m.get(key).like, m.get(key).age+1));
			}
			//System.out.println();
		}
		
		for(Integer key : m.keySet()) {
			System.out.print(key +" ");
		}
	}
	
	public static class Pair{
		int like;
		int age;
		Pair(int a, int b){
			this.like = a;
			this.age = b;
		}
	}

}
