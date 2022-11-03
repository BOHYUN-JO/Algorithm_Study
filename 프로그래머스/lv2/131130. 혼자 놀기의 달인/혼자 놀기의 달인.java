import java.util.*;

class Solution {
    static HashSet<Integer> opened;
    static PriorityQueue<Integer> pq ;
    public int solution(int[] cards) {
        int answer = 0;
        opened = new HashSet<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int score = 0;
        
        for(int i=0; i<cards.length; i++){
            if(!opened.contains(i+1)){
                opened.add(i+1);
                open(cards, i+1, 1);
            }
        }
        
        if(pq.size() < 2){
            return 0;
        }
        
        return pq.poll()*pq.poll();
    }
    
    public static void open(int[] cards,int idx, int count){
        if(!opened.contains(cards[idx-1])){
            opened.add(cards[idx-1]);
            open(cards, cards[idx-1], count+1);
        }else{
            pq.add(count);
            return;
        }
    }
}