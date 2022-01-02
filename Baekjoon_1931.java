import java.io.*;
import java.util.*;

public class Baekjoon_1931 {
	static int N;
	static Schedule[] list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new Schedule[N];
		for(int i=0 ; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new Schedule(start, end);
		}
		Arrays.sort(list);
		int ans = 1;
		int prev = list[0].end;
		for(int i=1; i<N; i++) {
			if(list[i].start >= prev) {
				ans++;
				prev = list[i].end;
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static class Schedule implements Comparable<Schedule>{
		int start;
		int end;
		Schedule(int x, int y){
			this.start = x;
			this.end = y;
		}
		
		@Override
		public int compareTo(Schedule o2) {
			if(this.end == o2.end) {
				return this.start - o2.start;
			}
			return this.end - o2.end;
		}
	}

}
