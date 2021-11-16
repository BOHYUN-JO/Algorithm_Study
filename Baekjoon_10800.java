import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_10800 {
	static int N, total = 0;
	static Node[] arr;
	static int[] sum = new int[200001];
	static int[] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		ans = new int[N];
		Arrays.fill(ans,0);
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			Node tmp = new Node(i,c,s);
			arr[i] = tmp;
		}
		
		Arrays.sort(arr);
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			Node cur = arr[i];
			while(arr[idx].size < cur.size) {
				total += arr[idx].size;
				sum[arr[idx].color] += arr[idx].size;
				idx++;
			}
			ans[cur.idx] = total - sum[cur.color];
			
		}
		
		for(int i=0; i<N;i++) {
			System.out.println(ans[i]);
		}

	}
	
	public static class Node implements Comparable<Node>{
		public int idx;
		public int color;
		public int size;
		
		Node(int a, int b, int c){
			this.idx = a;
			this.color = b;
			this.size = c;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.size < o.size) {
				return -1;
			}else if(this.size == o.size) {
				return 0;
			}else return 1;
		}
	}

}
