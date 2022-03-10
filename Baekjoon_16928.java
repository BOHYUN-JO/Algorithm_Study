import java.io.*;
import java.util.*;

public class Baekjoon_16928 {
	static int N,M,ans=10000;
	static int map[] = new int[101];
	static boolean visited[] = new boolean[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i=1; i<=100; i++) {
			map[i] = i;
		}
		
		for(int i=0; i<N+M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x] = y;
		}
		visited[1] = true;
		bfs();
		System.out.println(ans);
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1,0));
		visited[1] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			/* 숫자가 100이 되면 종료 */
			if(cur.num == 100) {
				ans = Math.min(ans, cur.cnt);
				return;
			}
			
			/* 주사위 1부터 6까지 */
			for(int i=1; i<=6; i++) {
				int next = cur.num + i;
				
				/* 범위 체크 */
				if(next > 100 || map[next] > 100 ) continue;
				
				if(!visited[next] ) {
					visited[next] = true;
					q.add(new Node(map[next], cur.cnt+1));
				}
			}
		}
	}
	
	public static class Node{
		int num;
		int cnt;
		Node(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}

}
