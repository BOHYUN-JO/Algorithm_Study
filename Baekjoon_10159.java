import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_10159 {
	static int N,M;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(arr[i][k] == arr[k][j] && arr[i][k] !=0) {
						arr[i][j] = arr[i][k];
					}
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			int sum = N-1;
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				if(arr[i][j] != 0) sum--;
			}
			System.out.println(sum);
		}
		
	}

}
