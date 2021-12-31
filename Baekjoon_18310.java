import java.io.*;
import java.util.*;

public class Baekjoon_18310 {
	static int N;
	static int[] home;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		home = new int[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		if(N%2 == 1) {
			System.out.println(list.get(N/2));
		}else {
			System.out.println(Math.min(list.get(N/2), list.get(N/2-1)) );
		}
		
		
	}

}
