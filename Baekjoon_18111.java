import java.io.*;
import java.util.*;

public class Baekjoon_18111 {
	static int N,M,B;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int ansT = Integer.MAX_VALUE;
		int ansH = 0;
		for(int floor=min; floor<=max; floor++) {
			int blockCnt = B;
			int time=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] > floor) {
						blockCnt += map[i][j] - floor;
					}
				}
			}
			boolean flag = true;
			for(int i=0; i<N;i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] > floor) {
						time += (map[i][j] - floor)*2;
					}else if(map[i][j] <floor) {
						if(blockCnt >= floor - map[i][j]) {
							time += (floor-map[i][j]);
							blockCnt -= floor-map[i][j];
						}else {
							flag= false;
							break;
						}
					}
				}
				if(!flag) break;
			}
			
			if(flag) {
				if(time <ansT) {
					ansT = time;
					ansH = floor;
				}else if(time == ansT) {
					if(ansH < floor) {
						ansT = time;
						ansH = floor;
					}
				}
			}
		}
		
		System.out.println(ansT+" " + ansH);
		
	}

}
