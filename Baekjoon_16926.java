import java.io.*;
import java.util.*;

public class Baekjoon_16926 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
				
		int arr[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = 0;
		int y = 0;
		int n = N;
		int m = M;
		while(x<N/2 && y<M/2) {
			int len = n*2+m*2-4;
			int idx = 0;
			int temp[] = new int[len];
			
			// 왼쪽
			for(int i=0; i<n; i++) {
				temp[(idx+R)%len] = arr[x+i][y];
				idx++;
			}
			idx--;
			// 아래
			for(int i=0; i<m; i++) {
				temp[(idx+R)%len] = arr[N-1-x][y+i];
				idx++;
			}
			idx--;
			// 오른쪽
			for(int i=0; i<n; i++) {
				temp[(idx+R)%len] = arr[N-x-i-1][M-1-y];
				idx++;
			}
			idx--;
			// 위
			for(int i=0; i<m; i++) {
				temp[(idx+R)%len] = arr[x][M-y-i-1];
				idx++;
			}
			
			idx = 0; 
			// 왼쪽
			for(int i=0; i<n; i++) {
				arr[x+i][y] = temp[idx++];
			}
			idx--;
			// 아래
			for(int i=0; i<m; i++) {
				arr[N-1-x][y+i]= temp[idx++];
			}
			idx--;
			// 오른쪽
			for(int i=0; i<n; i++) {
				arr[N-x-i-1][M-1-y] = temp[idx++];
			}
			idx--;
			// 위
			for(int i=0; i<m-1; i++) {
				arr[x][M-y-i-1] = temp[idx++];
			}			
			x++;
			y++;
			n -= 2;
			m -= 2;
			if(x==N/2 && y==M/2) {
				if(N%2==1 && M%2 ==1) {
					arr[x][y] = arr[x][y];
				}
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] +" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
