import java.util.*;

class kakao_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        HashMap<String, Integer> books = new HashMap<>();
        TreeMap<String, Integer> cost = new TreeMap<>();
        
        for(int i=0; i<records.length; i++){
            String temp[] = records[i].split(" ");
            String time[] = temp[0].split(":");
            int hour = Integer.parseInt(time[0])*60;
            int min = Integer.parseInt(time[1]);
            int out = hour+min;
            
            if(books.containsKey(temp[1])){
                int in = books.get(temp[1]);
                books.remove(temp[1]);
                if(cost.containsKey(temp[1])){
                    cost.put(temp[1], cost.get(temp[1])+(out-in));
                }else{
                    cost.put(temp[1], out-in);
                }                             
            }else{
               books.put(temp[1], hour+min); 
            }
        }
        
        int out = 23*60+59;
        for(String key : books.keySet()){
            int in = books.get(key);
            if(cost.containsKey(key)){
                    cost.put(key,cost.get(key)+ (out-in));
            }else{
                cost.put(key, out-in);
            }
        }
        
        int idx = 0;
        answer = new int[cost.size()];
        for(String key : cost.keySet()){
            if(cost.get(key) > fees[0]){
                answer[idx] = fees[1]+(int)Math.ceil( ((double)cost.get(key)-(double)fees[0])/fees[2] ) *fees[3];
            }else{
                answer[idx] = fees[1];
            }
            idx++;
        }
        
        return answer;
    }
}