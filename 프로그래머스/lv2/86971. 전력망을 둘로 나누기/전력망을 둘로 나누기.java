import java.util.*;

class Solution {
    static ArrayList<Integer> tree[]; 
    static boolean visited[];
    static int min=987654321;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            tree[a].add(b);
            tree[b].add(a);
        }
        
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            Arrays.fill(visited, false);
            for(int j=0; j<tree[i].size(); j++){
                visited[tree[i].get(j)] = true;
                int a = bfs(i, visited);
                int b = n-a;
                //System.out.println(i+":"+a+" "+b);
                min = Math.min(min, Math.abs(a-b));
                visited = new boolean[n+1];
            }
        }
        
        return min;
    }
    
    public static int bfs(int start, boolean[] visited ){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;
        
        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<tree[cur].size() ; i++){
                int next = tree[cur].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}