import java.util.*;

class kakao_k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = change(n,k);
        
        String[] temp = str.split("0");
        
        for(int i=0; i<temp.length; i++){
            
            if(isDigit(temp[i]) && isPrime(Long.parseLong(temp[i]))){
                answer++;
            }
        }
        
        return answer;
    }
    public static boolean isDigit(String str){
        if(str.length()<1){
            return false;
        }
        
        for(int i=0; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        
        return true;
    }
    public static boolean isPrime(long num){
        if(num <= 1){
            return false;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
               
    public static String change(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            int div = n / k;
            int mod = n % k;
            
            sb.append(mod);
            n = div;
        }
        
        return sb.reverse().toString(); 
    }
                        
}