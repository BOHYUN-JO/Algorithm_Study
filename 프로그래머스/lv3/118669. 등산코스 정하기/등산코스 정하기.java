import java.util.*;

class Solution {
    static ArrayList<Pair>[] map;
    static int intensity = Integer.MAX_VALUE;
    static int num = Integer.MAX_VALUE;
    static HashSet<Integer> gateSet = new HashSet<>();
    static HashSet<Integer> summitSet = new HashSet<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        map = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i=0; i<gates.length; i++){
            gateSet.add(gates[i]);
        }
        
        for(int i=0; i<summits.length; i++){
            summitSet.add(summits[i]);
        }
        
        for(int i=0; i<paths.length; i++){
            int a = paths[i][0];
            int b = paths[i][1];
            int w = paths[i][2];
            
            if(gateSet.contains(a) || summitSet.contains(b) ){
                map[a].add(new Pair(b,w));
            }else if(gateSet.contains(b) || summitSet.contains(a) ){
                map[b].add(new Pair(a,w));
            }else{
                map[a].add(new Pair(b,w));
                map[b].add(new Pair(a,w));
            }
        }
        
        dijkstra(gates, n, summits);
        
        answer[0] = num;
        answer[1] = intensity;
        
        return answer;
    }
    
    public static void dijkstra(int[] gates, int n, int[] summits){
        Queue<Pair> q = new LinkedList<>();
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int gate : gates){
            q.add(new Pair(gate, 0));
            dist[gate] = 0;
        }
                
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            if(cur.w > dist[cur.link]) continue;
            
            for(int i=0; i<map[cur.link].size(); i++){
                Pair next = map[cur.link].get(i);
                
                int dis = Math.max(dist[cur.link], next.w);
                if(dist[next.link] > dis){
                    dist[next.link] = dis;
                    q.add(new Pair(next.link, dis));
                }                
            }
        }
        
        Arrays.sort(summits);
        
        for (int summit : summits) {
            if (dist[summit] < intensity) {
                num = summit;
                intensity = dist[summit];
            }
        }
        
        
        
    }
    
    public static class Pair{
        int link;
        int w;
        Pair(int link, int w){
            this.link = link;
            this.w = w;
        }
    }
}