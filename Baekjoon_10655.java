import java.io.*;
import java.util.*;

public class Baekjoon_10655 {
	static int N,ans,total;
	static Pair p[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		p = new Pair[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		total = getTotal(); 
		ans = Integer.MAX_VALUE;
		for(int i=1; i<N-1; i++) {
			int temp = check(i);
			if(temp < ans) {
				ans = temp;
			}
		}
		
		System.out.println(ans);
	}
	private static int getTotal() {
		int sum = 0;
		int cx = p[0].x, cy = p[0].y;
		int nx, ny;
		
		for(int i=1; i<N; i++) {
			nx = p[i].x;
			ny = p[i].y;
			sum += Math.abs(nx-cx) + Math.abs(ny-cy);
			cx = nx;
			cy = ny;
		}
		
		return sum;
	}
	private static int check(int skip) {
		int sum = total;
		sum -= Math.abs(p[skip].x-p[skip-1].x) + Math.abs(p[skip].y-p[skip-1].y);
		sum -= Math.abs(p[skip+1].x-p[skip].x) + Math.abs(p[skip+1].y - p[skip].y);
		sum += Math.abs(p[skip+1].x-p[skip-1].x) + Math.abs(p[skip+1].y-p[skip-1].y);
		
		return sum;
	}
	
	private static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
