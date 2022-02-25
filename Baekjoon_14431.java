import java.io.*;
import java.util.*;

public class Baekjoon_14431 {
	static int sx,sy,ex,ey, N;
	static ArrayList<Node> graph[];
	static boolean prime[];
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+2];
		for(int i=0; i<N+2; i++) {
			graph[i] = new ArrayList<>();
		}
		ArrayList<Node> temp = new ArrayList<>();
		temp.add(new Node(sx,sy));	// 시작점 추가
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			temp.add(new Node(x,y));
		}
		temp.add(new Node(ex,ey));	// 끝점 추가
		
		/* 에라토스테네스의 체를 이용한 소수 구하기 */
		prime = new boolean[12001];
		getPrime();
		
		/* 모든 정점 간의 길이 구하기 - 소수인 경우에만 연결 */
		for(int i=0; i< temp.size() ; i++) {
			for(int j=i+1; j< temp.size(); j++) {
				int dis = getDis(temp.get(i).x, temp.get(i).w, temp.get(j).x, temp.get(j).w);
				if(!prime[dis]) {	// 거리가 소수라면
					graph[i].add(new Node(j,dis));
					graph[j].add(new Node(i,dis));
				}
			}
		}
		dijkstra();
	}
	
	/* 에라토스테네스의 체 이용하여 소수 구하기 */
	static void getPrime() {
		prime[0] = true;
        prime[1] = true;
        for(int i=2; i*i<=12000; i++) {
			if(!prime[i]) {
				for(int j=i+i; j<=12000; j += i) {
					prime[j] = true;
				}
			}
		}
	}
	
	static int getDis(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt( (int)Math.pow((x2-x1), 2) + (int)Math.pow(y2-y1, 2));
	}
	
	static class Node{
		int x;
		int w;
		Node(int x, int w){
			this.x = x;
			this.w = w;
		}
		
	}
	
	/* 다익스트라 알고리즘 */
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>( (o1,o2) -> o1.w-o2.w );
		pq.add(new Node(0,0));
		
		int dis[] = new int[N+2];
		Arrays.fill(dis, 1000000000);
		dis[0] = 0;	
		
		while(!pq.isEmpty()) {
			int cur = pq.peek().x;
			int curW = pq.poll().w;		
			if(curW > dis[cur]) continue;
			for(int i=0; i<graph[cur].size(); i++) {
				int next = graph[cur].get(i).x;
				int nextW = graph[cur].get(i).w;
				if(dis[next] > dis[cur] + nextW) {
					dis[next] = dis[cur]+nextW;
					pq.add(new Node(next,dis[next]));
				}
			}
		}
		
		if(dis[N+1] == 1000000000) {
			System.out.println(-1);
		}else {
			System.out.println(dis[N+1]);
		}
	}

}