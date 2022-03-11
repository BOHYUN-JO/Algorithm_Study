import java.io.*;
import java.util.*;
public class Baekjoon_15724 {
	static int N,M,K;
	static int map[][];
	static int preSum[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		preSum = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
				preSum[i][j] = sum;
			}
		}
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j=x1; j<=x2; j++) {
				sum += preSum[j][y2]-preSum[j][y1-1];
			}
			System.out.println(sum);
		}		
		
	}

}
