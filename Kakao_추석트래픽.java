import java.util.*;

class Kakao_추석트래픽 {
    public int solution(String[] lines) {
        int answer = 0;
        Pair arr[] = new Pair[lines.length];
        for(int i=0; i<lines.length; i++){
            arr[i] = str2time(lines[i]);
        }
        
        for(int i=0; i<arr.length; i++){
            answer = Math.max(answer, count(arr[i].start, arr, i));
            answer = Math.max(answer, count(arr[i].end, arr, i));
        }
        
        return answer;
    }
    
    static int count(int start, Pair[] arr, int i){
        int end = start + 1000;
        int cnt = 1;
        for(int j=0; j<arr.length; j++){
            if(i==j) continue;
            if( arr[j].end < start || arr[j].start >= end ) continue;
            cnt++;
        }
        return cnt;
    }
    
    static Pair str2time(String str){
        String[] temp = str.split(" ");
       
        String[] tmp = temp[1].split(":");
        int hour = Integer.parseInt(tmp[0])*60*60*1000;
        int min = Integer.parseInt(tmp[1])*60*1000;
        int sec = Integer.parseInt(tmp[2].substring(0,2))*1000 + Integer.parseInt(tmp[2].substring(3,6));
        
        int calTime = 0;
        if(temp[2].length()> 2){
           calTime = Integer.parseInt(temp[2].substring(0,1))*1000 + Integer.parseInt(temp[2].substring(2,temp[2].length()-1)); 
        }else{
            calTime = Integer.parseInt(temp[2].substring(0,1))*1000;
        }
        
        int end = hour+min+sec;
        int start = end - calTime +1;
        
        return new Pair(start, end);
    }
    
    static class Pair{
        int start;
        int end;
        Pair(int a, int b){
            this.start = a;
            this.end = b;
        }
    }
}