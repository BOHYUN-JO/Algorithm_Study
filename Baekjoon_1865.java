import java.io.*;
import java.util.*;

public class Baekjoon_1865 {
	static int N,M,W;
	static Node[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			dist = new int[N+1];
			graph = new Node[2*M+W];
			
			int idx = 0;
			
			for(int i=0; i<M+W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				if(i<M) {
					graph[idx++] = new Node(s,e,cost);
					graph[idx++] = new Node(e,s,cost);
				}else {
					graph[idx++] = new Node(s,e,-cost);
				}
			}
			
			if(bellmanFord()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	static boolean bellmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<graph.length; j++) {
				Node node = graph[j];
				
				if(dist[node.s] != INF && dist[node.s]+ node.cost < dist[node.e]) {
					dist[node.e] = dist[node.s] + node.cost;
				}
			}
		}
		
		for(int i=0; i<graph.length; i++) {
			Node node = graph[i];
			
			if(dist[node.s] != INF && dist[node.s]+node.cost < dist[node.e]) {
				return true;
			}
		}
		
		return false;
	}
	
	
	static class Node{
		int s;
		int e;
		int cost;
		
		Node(int s, int e, int cost){
			this.s = s;
			this.e = e;
			this.cost = cost;
		}
	}

}
