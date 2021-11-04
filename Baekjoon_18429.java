import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_18429 {
	static int N,K,weight = 500, ans=0;
	static int[] kit;
	static boolean[] visited;
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		kit = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(kit); 
		
		for(int i=0; i<N; i++) {
			Arrays.fill(visited,false);
			check(i,0,500);
		}
		
		System.out.println(ans);
		
	}
	
	static void check(int cur, int depth, int w) {
		visited[cur] = true;
		int curWeight = kit[cur];
		
		if(w < 500) return;
		
		if(depth == N-1) {
			ans++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				check(i, depth+1, w+curWeight-K);
				visited[i] = false;
			}
		}
		
	}

}
