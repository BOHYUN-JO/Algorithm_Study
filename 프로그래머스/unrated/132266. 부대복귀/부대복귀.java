import java.util.*;

class Solution {
    static class Node{
        int v; //간선
        int cost; //가중치

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
        
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Node>();
        }
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            graph[a].add(new Node(b,1));
            graph[b].add(new Node(a,1));
        }
        
        dijkstra(destination);
        
        for(int i=0; i<sources.length; i++){
            if(dist[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = dist[sources[i]];
            }
        }
                
        return answer;
    }
    
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1, o2) -> o1.cost-o2.cost );
        
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            for(Node next : graph[cur.v]){
                if(!visited[next.v] && dist[next.v] > cur.cost + next.cost){
                    dist[next.v] = cur.cost + next.cost;
                    visited[next.v] = true;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
                        
    }
}