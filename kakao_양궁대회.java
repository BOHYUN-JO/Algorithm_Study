import java.util.*;

class kakao_¾ç±Ã´ëÈ¸ {
    static int[] combi = new int[11];
    static int[] ans = new int[11];
    static int[] result = new int[11];
    static int max = 0;
    static boolean flag;
    public int[] solution(int n, int[] info) {
        int[] answer;
        dfs(0, info,n,0);
        if(flag && max != 0){
            answer = new int[11];
            answer = ans;
        }else{
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

    
    public static void dfs(int cnt, int[] info, int n, int idx){
        if(cnt >= n){
            check(info, n);
            return;
        }
        
        for(int i=idx; i<11; i++){
            result[cnt] = i;
            dfs(cnt+1, info, n, i);
        }
        
    }
    public static void check(int[] info, int n){
        int ryan = 0;
        int apeach = 0;
        
        Arrays.fill(combi, 0);
        for(int i=0; i<n; i++){
            combi[result[i]]++;
        }
        
        for(int i=0; i<11; i++){
            if(info[i] < combi[i]){
                ryan += 10-i; 
            }else{
                if(info[i] > 0){
                    apeach += 10-i;
                }
            }
        }
        
        if(ryan-apeach > max ){
            flag = true;
            max = ryan-apeach;
            for(int i=0; i<11; i++){
                ans[i] = combi[i];
            }
        }else if(ryan-apeach == max ){
            flag = true;
            boolean dictFlag = false;
            for(int i=10; i>=0; i--){
                if(ans[i] < combi[i]){
                    dictFlag = true;
                    break;
                }else if(ans[i] > combi[i]){
                    break;
                }
            }
            if(dictFlag){
                for(int i=0; i<11; i++){
                    ans[i] = combi[i];
                }
            }            
            
        }
    }
    
}