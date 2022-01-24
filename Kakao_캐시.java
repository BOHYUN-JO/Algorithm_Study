import java.util.*;

class kakao_캐시 {
    public int main(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> cache = new HashMap<>();
        
        for(int i=0; i< cities.length; i++){
            String city = cities[i].toUpperCase();
            if(cache.containsKey(city)){   // hit
                answer +=1;
                cache.put(city, 0);
            }else{  // miss
                answer += 5;
                if(cacheSize == 0) continue;    // cache에 넣을 수 없음
                if(cache.size() >= cacheSize){   // cache 꽉참, 가장 오래 사용 안된 것 삭제
                    int max = 0;
                    String maxKey = "";
                    for(String key : cache.keySet()){
                        if(max < cache.get(key)){
                            max = cache.get(key);
                            maxKey = key;
                        }
                    }
                    cache.remove(maxKey);   
                }
                cache.put(city, 0);
            }
            /* aging */
            for(String key : cache.keySet()){
                cache.put(key, cache.get(key)+1);    
            }
        }
        
        return answer;
    }
    
}