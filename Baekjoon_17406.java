import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_17406 {
	static int N,M,K, ans=Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] visited;
	static int[] order;
	static ArrayList<ArrayList<Integer>> rotate;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		visited = new boolean[K];
		order = new int[K];
		rotate = new ArrayList<ArrayList<Integer>>();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(r); temp.add(c); temp.add(s);
			rotate.add(temp);
		}
		
		permutation(0);
		
		System.out.println(ans);

	}
	
	public static void permutation(int idx) {
		if(idx == K) {
			int[][] copy = new int[N+1][M+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M;j++) {
					copy[i][j] = arr[i][j];
				}
			}
			for(int i=0; i<K; i++) {
				int p = order[i];
				int r = rotate.get(p).get(0);
				int c = rotate.get(p).get(1);
				int s = rotate.get(p).get(2);
				rotateArray(copy, r,c,s);
			}
			rowcal(copy);
			return;
		}
		for(int i=0; i<K; i++) {
			if(visited[i]) continue;
			
			order[idx] = i;
			visited[i] = true;
			permutation(idx+1);
			visited[i] = false;
		}
	}
	
	public static void rotateArray(int copy[][], int r, int c, int s) {
		int sr = r-s;
		int sc = c-s;
		int dr = r+s;
		int dc = c+s;
		
		while(sr < dr && sc<dc) {
			rotate(sr,sc,dr,dc, copy);
			sr++; dr--;
			sc++; dc--;
		}
		
	}
	public static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
        
        
        int[] temp = new int[3]; //방향별로 값을 옮기다 보면 지워질 수 있는 좌표값을 저장.
        temp[0] = copy[lx][ry];
        temp[1] = copy[rx][ry];
        temp[2] = copy[rx][ly];
        
        //오른쪽으로 회전
        for(int i = ry; i > ly; i--) {
            copy[lx][i] = copy[lx][i - 1];
        }
        //아래로 회전
        for(int i = rx; i > lx; i--) {
            if(i == lx + 1) copy[i][ry] = temp[0];
            else copy[i][ry] = copy[i - 1][ry];
        }
        //왼쪽으로 회전
        for(int i = ly; i < ry; i++) {
            if(i == ry - 1) copy[rx][i] = temp[1];
            else copy[rx][i] = copy[rx][i + 1];
        }
        //위로 회전
        for(int i = lx; i < rx; i++) {
            if(i == rx - 1) copy[i][ly] = temp[2];
            else copy[i][ly] = copy[i + 1][ly];
        }    
        
    }
	
	public static void rowcal(int[][] copy) {
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= M; j++) {
                sum += copy[i][j];
            }
            ans = Math.min(ans, sum);
        }
    }
	
	
}
