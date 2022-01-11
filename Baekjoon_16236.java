import java.io.*;
import java.util.*;

public class Baekjoon_16236 {
	static int N, bx, by, bSize, eaten=0, ans=0;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					bx = i;
					by = j;
					bSize=2;
				}
			}
		}
		
		while(true) {
			if(!bfs()) {
				break;
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(map[i][j] +" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			if(eaten == bSize) {
				bSize++;
				eaten = 0;
			}
		}
		
		System.out.println(ans);
		
	}
	public static boolean bfs() {
		Queue<Tuple> q = new LinkedList<>();
		boolean visited[][] = new boolean[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], false);
		}
		int minDis = Integer.MAX_VALUE;
		int tx = bx;
		int ty = by;
		int tDis = 0;
		
		q.add(new Tuple(bx,by,0));
		visited[bx][by] = true;
		
		while(!q.isEmpty()) {
			Tuple cur = q.poll();
			if(map[cur.x][cur.y] > 0 && map[cur.x][cur.y] < bSize && map[cur.x][cur.y] < 9) {
				if(minDis > cur.dis) {
					minDis = cur.dis;
					tx = cur.x;
					ty = cur.y;
					tDis = cur.dis;
				}else if(minDis == cur.dis) {
					if(cur.x < tx) {
						tx = cur.x;
						ty = cur.y;
						tDis = cur.dis;
					}else if(cur.x == tx){
						if(cur.y < ty) {
							tx = cur.x;
							ty = cur.y;
							tDis = cur.dis;
						}
					}
				}
			}
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx<0 || ny <0 || nx >=N || ny >=N) continue;
				
				if(!visited[nx][ny] && map[nx][ny] <=bSize) {
					visited[nx][ny] = true;
					q.add(new Tuple(nx,ny, cur.dis +1));
				}
			}
		}
		
		if(tx == bx && ty == by) return false;
		else {
			map[bx][by] = 0;
			bx = tx;
			by = ty;
			map[bx][by] = 9;
			ans += tDis;
			eaten++;
			return true;
		}
	}
	
	public static class Tuple{
		int x;
		int y;
		int dis;
		Tuple(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.dis = z;
		}
	}

}
