import java.io.*;
import java.util.*;

public class Baekjoon_9205 {
	static int n;
	static ArrayList<Point> list;	// 편의점 리스트
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0) {
			n = sc.nextInt();
			list = new ArrayList<>();
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			for(int i=0; i<n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list.add(new Point(x,y,0));
			}
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			visited = new boolean[n];
			bfs(sx,sy, ex, ey);
		}
	}
	
	static void bfs(int sx, int sy, int ex, int ey) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sx,sy,1000));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			/* 현재 좌표에서 페스티벌에 갈 수 있다면 */
			if(cur.meter >= getDis(cur.x,cur.y,ex,ey)) {
				System.out.println("happy");
				return;
			}
			for(int i=0; i<n; i++) {
				Point next = list.get(i);
				int dis = getDis(cur.x, cur.y, next.x, next.y);
				if(!visited[i] && dis <= cur.meter ) {	// 현재 위치에서 갈 수 있는 곳이라면
					visited[i] = true;
					q.add(new Point(next.x, next.y, 1000));
				}
			}
		}
		
		System.out.println("sad");
	}
	
	/* 맨해튼 거리 반환 */
	static int getDis(int x1,int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	static class Point{
		int x;
		int y;
		int meter;
		Point(int x, int y, int meter){
			this.x = x;
			this.y = y;
			this.meter = meter;
		}
	}

}
