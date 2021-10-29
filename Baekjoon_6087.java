import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_6087 {
	static Node start,end;
	
	static class Node implements Comparable<Node>{
		private int x;
		private int y;
		private int dir;
		private int cnt;
		
		Node(int x, int y, int dir, int cnt){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.cnt - other.cnt;
		}
	}

	public static void main(String[] args) throws Exception{
		int H,W;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		char[][] arr = new char[H][W];
		
		boolean flag = false;
		for(int i=0; i< H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == 'C') {
					if(flag) end = new Node(j,i,4,0);
					else {
						start = new Node(j,i,4,0);
						flag = true;
					}
				}
			}
		}
		
		System.out.println(bfs(H,W,arr));
		
	}
	
	public static int bfs(int H, int W, char[][] arr) {
		Queue<Node> q = new PriorityQueue<>();
		int[][] visited = new int[H][W];
		int[] my = {-1,1,0,0};
		int[] mx = {0, 0,-1,1};
		
		for(int i=0; i<H ; i++) {
			Arrays.fill(visited[i], W*H);
		}
		
		q.add(start);
		visited[start.y][start.x] = 0;
		while(!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			int dir = q.peek().dir;
			int cnt = q.peek().cnt;
			q.poll();
			if(y == end.y && x == end.x){
				return cnt;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y + my[i];
				int nx = x + mx[i];
				if(ny<0 || nx<0 || ny>=H || nx >=W || arr[ny][nx] == '*') continue;
				
				if(dir == i || dir == 4 ) {
					if(visited[ny][nx] >= cnt) {
						visited[ny][nx] = cnt;
						q.add(new Node(nx,ny,i,cnt));
					}
				}else {
					if(visited[ny][nx] >= cnt+1) {
						visited[ny][nx] = cnt +1;
						q.add(new Node(nx,ny,i, cnt+1));
					}
				}
			}
		}
		return -1;
	}

}
