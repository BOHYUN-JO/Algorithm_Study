import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Baekjoon_10836 {
	static int M,N;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M+1][M+1];
		for(int i=0; i<M; i++) {
			Arrays.fill(arr[i], 1);
		}
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sum(a,b,c);
		}
		
		for(int i=1; i<M; i++) {
			for(int j=1; j<M; j++) {
				arr[j][i] = arr[0][i];
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	private static void sum(int a,int b,int c) {
		int x = M-1;
		int y = 0;
		if(a>=2*M-1) return;
		
		if(x-a < 0) {
			y = -(x-a);
			x = 0;
		}else {
			x = x-a;
		}
		
		for(int i=0; i<b; i++) {
			arr[x][y] += 1;
			if(x>0) {
				x--;
			}else {
				y++;
			}
		}
		
		for(int i=0; i<c; i++) {
			arr[x][y] +=2;
			if(x>0) {
				x--;
			}else {
				y++;
			}
		}
		
	}

}
