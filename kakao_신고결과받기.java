import java.util.*;

public class kakao_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> reportCnt = new HashMap<>();
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        
        for(int i=0; i<report.length; i++){
            String temp[] = report[i].split(" ");
            
            if(!reportMap.containsKey(temp[0])){
                reportMap.put(temp[0], new ArrayList<String>());
            }
            
            if(!visited.contains(report[i])){
                visited.add(report[i]);
                reportMap.get(temp[0]).add(temp[1]);
                reportCnt.compute(temp[1], (key,v) -> v==null ? 1 : v+1);
            }   
        }        
        
        for(int i=0; i<id_list.length; i++){
            int cnt = 0;
            if(!reportMap.containsKey(id_list[i])){
                answer[i] = 0;
                continue;
            }
            
            for(String cur : reportMap.get(id_list[i])){
                if(reportCnt.containsKey(cur) && reportCnt.get(cur) >= k){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}