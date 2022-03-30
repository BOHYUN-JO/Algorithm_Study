import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_1613 {
	static final int INF = 100000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dist[][] = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				if(i==j) {
					dist[i][j] = 0;
				}else {
					dist[i][j] = INF;
				}
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
		}
		for(int k=0; k<=N; k++) {
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		int S = Integer.parseInt(br.readLine());
		for(int i=0; i<S; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(dist[a][b] == INF && dist[b][a] == INF) {
				System.out.println(0);
			}else if(dist[a][b] != INF) {
				System.out.println(-1);
			}else {
				System.out.println(1);
			}
		}
		
	}

}
