import java.io.*;
import java.util.*;

public class Baekjoon_16946 {
	static int N, M;
	static int arr[][];
	static Point ans[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M];
		ans = new Point[N][M];
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) -'0';
				ans[i][j] = new Point(0,0);
			}
		}
		
		int num = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0 && !visited[i][j]) {
					bfs(i,j, num++);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 1) {
					check(i,j);
				}else {
					sb.append(0);
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	/* 4���� ���� */
	public static void check(int x, int y) {
		HashSet<Integer> dict = new HashSet<>();
		int cnt = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny <0 || nx >=N || ny >= M) continue;
			/* 0�̸鼭 �ٸ� ������ ��쿡�� ������ */
			if(arr[nx][ny] == 0 && !dict.contains(ans[nx][ny].y)) {
				cnt += ans[nx][ny].x;
				dict.add(ans[nx][ny].y);
			}
		}
		
		sb.append(cnt%10);
	}
	
	/* 0�� ������ ã�� �Լ� */
	public static void bfs(int x, int y, int num) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		
		/* 0 ���� ��ǥ ������ ť */
		Queue<Point> temp = new LinkedList<>();
		temp.add(new Point(x,y));
		
		int cnt = 1;	// 0�� ���� count (������ �����ؼ� 1)
		visited[x][y] = true;
		
 		while(!q.isEmpty()) {
 			Point cur = q.poll();
 			for(int i=0;i<4; i++) {
 				int nx = cur.x + dx[i];
 				int ny = cur.y + dy[i];
 				
 				if(nx < 0 || ny <0 || nx >=N || ny >=M ) continue;
 				
 				if(!visited[nx][ny] && arr[nx][ny] == 0) {
 					visited[nx][ny] = true;
 					q.add(new Point(nx,ny));
 					temp.add(new Point(nx,ny));
 					cnt++;
 				}
 			}
		}
 		
 		/* 0���� ���� ǥ�� */ 
 		while(!temp.isEmpty()) {
 			Point cur = temp.poll();
 			ans[cur.x][cur.y].x = cnt;	// ����	
 			ans[cur.x][cur.y].y = num;	// ���� ��ȣ
 		}
 		
	}
	
	public static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
}