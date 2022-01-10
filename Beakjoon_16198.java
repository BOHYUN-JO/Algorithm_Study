import java.io.*;
import java.util.*;

public class Beakjoon_16198 {
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			 list.add(Integer.parseInt(st.nextToken()));
		}
		dfs(list,0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(ArrayList<Integer> list, int sum) {
		if(list.size()<=2) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i=1; i<list.size()-1; i++) {
			int temp = list.get(i);
			int num = list.get(i-1)*list.get(i+1);
			list.remove(i);
			dfs(list, sum+num);
			list.add(i, temp);
		}
	}

}
