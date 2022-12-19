import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int num;
        int cnt;
        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node other){
            if(this.cnt == other.cnt){
                return this.num - other.num;
            }
            return other.cnt - this.cnt;
        }
    }
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        int[] temp = new int[e+1];
        ArrayList<Node> list = new ArrayList<>();
        
        for(int i=1; i<=e; i++){
            int num = i;
            while(num <=e){
                temp[num] +=1;
                num += i;
            }
        }
        
        for(int i=1; i<=e; i++){
            list.add(new Node(i, temp[i]));
        }
        
        Collections.sort(list);
        
        for(int i=0; i<starts.length; i++){
            int s = starts[i];
            for(Node cur : list){
                if(s<= cur.num){
                    answer[i] = cur.num;
                    break;
                }
            }
        }        
        
        return answer;
    }
}