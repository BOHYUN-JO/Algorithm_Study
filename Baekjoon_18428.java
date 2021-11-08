import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_18428 {
	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static boolean flag;
	static ArrayList<Integer> teacher;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		teacher = new ArrayList<>();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if(arr[i][j] == 'T') {
					teacher.add(cnt);
				}
				cnt++;
			}
			
		}
		dfs(0,0);
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	
	private static void dfs(int idx, int cnt) {
		if(flag) return;
		if(idx == N*N) {
			return;
		}
		if(cnt == 3) {
			if(check()) {
				flag = true;
			}
			return;
		}
		
		int x = idx/N;
		int y = idx%N;
		if(arr[x][y] == 'X') {
			arr[x][y] = 'O';
			dfs(idx+1, cnt+1);
			arr[x][y] = 'X';
		}
		dfs(idx+1, cnt);
		
	}
	
	static boolean check() {
		for(int k : teacher) {
			for(int i=0; i<4; i++) {
				int cx = k/N;
				int cy = k%N;
				while(true) {
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if(nx<0 || nx>=N || ny <0 || ny>=N || arr[nx][ny] =='O') break;
					if(arr[nx][ny] == 'S') return false;
					cx = nx;
					cy = ny;
				}
				
			}
		}
		return true;
	}

}
