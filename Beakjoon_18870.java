import java.io.*;
import java.util.*;

public class Beakjoon_18870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashMap<Integer, Integer> ans = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(arr[i]);
		}
		
		int cnt = -1;
		while(!pq.isEmpty()) {
			int num = pq.poll();
			if(ans.containsKey(num)) {
				continue;
			}else {
				cnt++;
				ans.put(num, cnt);
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(ans.get(arr[i]));
			if(i < N-1) sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
