import java.util.*;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long total = 0;
        int add = price;
        
        for(int i=0; i<count; i++){
            total += add;
            add += price;
        }
        
        if(total > money){
            return total - money;
        }else return 0;
        

    }
}