import java.util.*;
import java.io.*;

public class Baekjoon_20924 {
	static int N,R, Giga, max, pillar;
	static ArrayList<Node> tree[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());	
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			tree[a].add(new Node(b,d));
			tree[b].add(new Node(a,d));
		}
		
		if(N != 1) {
			visited = new boolean[N+1];
			visited[R] = true;
			findGiga(R,0, visited);
			findLong(Giga,0,visited);
		}
				
		System.out.println(pillar+" "+ max);
		
	}
	
	static void findGiga(int cur, int sum, boolean[] visited) {
		if(tree[cur].size() > 2 || (tree[cur].size() == 1 && cur != R ) || (tree[cur].size()==2 && cur==R)) {
			pillar = sum;
			Giga = cur;
			return;
		}
		
		for(int i=0; i<tree[cur].size(); i++) {
			int next = tree[cur].get(i).next;
			int d = tree[cur].get(i).d;
			
			if(!visited[next]) {
				visited[next] = true;
				findGiga(next, sum+d, visited);
			}
			
		}
		return ;
	}
	
	static void findLong(int cur, int sum, boolean[] visited) {
		if(tree[cur].size() == 1) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<tree[cur].size(); i++) {
			int next = tree[cur].get(i).next;
			int d = tree[cur].get(i).d;
			if(!visited[next]) {
				visited[next] = true;
				findLong(next, sum+d, visited);
				visited[next] = false;
			}
		}
		
		return;
	}
	
	
	static class Node{
		int next;
		int d;
		Node(int n, int d){
			this.next = n;
			this.d = d;
		}
	}

}
