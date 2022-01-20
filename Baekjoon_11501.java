import java.io.*;
import java.util.*;

public class Baekjoon_11501 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			long ans=0;
			int stocks[] = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				stocks[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i=N-1; i>=0; i--) {
				if(stocks[i] > max) {
					max = stocks[i];
				}else {
					ans += max - stocks[i];
				}
			}
			System.out.println(ans);
		}
	}
}
