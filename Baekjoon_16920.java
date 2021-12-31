import java.io.*;
import java.util.*;

public class Baekjoon_16920 {
	static int N, M, P, wallCnt=0;
	static char[][] board;
	static int[] S;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] ans;
	static Queue<Tuple>[] qList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		board = new char[N+1][M+1];
		S = new int[P+1];
		ans = new int[P+1];
		qList = new Queue[P+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=P; i++) {
			qList[i] = new LinkedList<>();
			S[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				char ch = tmp.charAt(j);
				if(ch>='1' && ch<='9') {
					qList[ch-'0'].add(new Tuple(i,j,0));
					ans[ch-'0']++;
				}else if(ch == '#') wallCnt++;
				board[i][j] = ch;
			}
		}
		
		while(check()) {
			for(int i=1; i<=P; i++) {
				bfs(i);
			}
		}
		
		for(int i=1; i<=P ; i++) {
			System.out.print(ans[i]+" ");
		}
		
	}
	public static boolean check() {
		int sum=wallCnt;
		for(int i=1; i<=P; i++) {
			sum += ans[i];
		}
		if(sum == N*M) return false;
		
		for(int i=1; i<=P; i++) {
			if(!qList[i].isEmpty()) return true;
		}
		
		return false;
	}
	
	public static void bfs(int idx) {
		Queue<Tuple> q = new LinkedList<>();
		while(!qList[idx].isEmpty()) {
			q.add(qList[idx].poll());
		}
		char target = (char)idx;
		
		while(!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			int cCnt = q.peek().cnt;
			q.poll();
			
			if(cCnt >= S[idx]) continue;
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx < 0 || ny <0 || nx>=N || ny>=M) continue;
				
				if(board[nx][ny] == '.') {
					board[nx][ny] = target;
					q.add(new Tuple(nx,ny,cCnt+1));
					qList[idx].add(new Tuple(nx,ny,0));
					ans[idx]++;
				}
			}
		}
	}
	
	public static class Tuple{
		int x;
		int y;
		int cnt;
		Tuple(int x, int y, int z){
			this.x= x;
			this.y = y;
			this.cnt = z;
		}
	}

}
