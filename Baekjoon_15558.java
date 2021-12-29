import java.io.*;
import java.util.*;

public class Baekjoon_15558 {
	static int N,k;
	static String[] line = new String[2];
	static boolean[][] visited = new boolean[2][100001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		line[0] = br.readLine();
		line[1] = br.readLine();
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0; i<2; i++) {
			Arrays.fill(visited[i], false);
		}
		
		q.add(new Pair(0,0,0));
		visited[0][0] = true;
		
		
		while(!q.isEmpty()) {
			int idx = q.peek().idx;
			int lineIdx = q.peek().line;
			int cnt = q.peek().cnt;
			q.poll();
			
			if(idx+1 >=N || idx+k >= N) return 1;
			
			if(idx-1>=0 && idx-1>cnt && !visited[lineIdx][idx-1] && line[lineIdx].charAt(idx-1)=='1') {
				q.add(new Pair(idx-1, lineIdx, cnt+1));
				visited[lineIdx][idx-1] = true;
			}
			
			if(idx+1 <line[0].length() && idx+1>cnt && !visited[lineIdx][idx+1] && line[lineIdx].charAt(idx+1) == '1'  ) {
				q.add(new Pair(idx+1, lineIdx, cnt+1));
				visited[lineIdx][idx+1] = true;
			}
			
			if(idx+k <line[0].length() && idx+k >cnt && !visited[(lineIdx+1)%2][idx+k] &&line[(lineIdx+1)%2].charAt(idx+k)=='1' ) {
				q.add(new Pair(idx+k, (lineIdx+1)%2, cnt+1));
				visited[(lineIdx+1)%2][idx+k] = true;
			}
		}
		
		return 0;
		
	}
	
	public static class Pair{
		int idx;
		int line;
		int cnt;
		Pair(int x, int y, int z){
			this.idx = x;
			this.line = y;
			this.cnt = z;
		}
	}

}
