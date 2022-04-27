import java.util.*;

class kakao_¾ç°ú´Á´ë {
    static ArrayList<Integer> tree[];
    static int max=0;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        tree = new ArrayList[info.length];
        for(int i=0; i<info.length; i++){
            tree[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];
            tree[parent].add(child);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        dfs(info, 0,0,0,list);
        
        answer= max;
                       
        return answer;
    }
    
    public static void dfs(int info[], int s, int w, int idx, ArrayList<Integer> list){
        if(info[idx] == 0) s++;
        else w++;
        
        if(s<= w) return;
        
        max = Math.max(max, s);
        
        ArrayList<Integer> next = new ArrayList<>();
        next.addAll(list);
        
        next.remove(Integer.valueOf(idx));
        for(int i=0; i<tree[idx].size(); i++){
            next.add(tree[idx].get(i));
        }
        
        for(Integer cur : next){
            dfs(info, s,w, cur, next);
        }
        
    }
}