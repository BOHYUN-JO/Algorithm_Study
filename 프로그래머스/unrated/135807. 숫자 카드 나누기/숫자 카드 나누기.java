import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        ArrayList<Integer> gcdA = new ArrayList<>();
        ArrayList<Integer> gcdB = new ArrayList<>();
        
        gcdA = getGcd(arrayA, gcdA);
        gcdA = getGcd(arrayA, gcdA);
        
        for(int gcd : gcdA){
            if(check(arrayB, gcd)){
                answer = Math.max(answer, gcd);
            }
        }
        gcdB = getGcd(arrayB, gcdB);
        gcdB = getGcd(arrayB, gcdB);
        
        for(int gcd : gcdB){
            if(check(arrayA, gcd)){
                answer = Math.max(answer, gcd);
            }
        }
        
        
        return answer;
    }
    
    public static boolean check(int[] arr, int gcd){
        for(int i=0; i<arr.length; i++){
            if(arr[i] % gcd ==0){
                return false;
            }
        }
        
        return true;
    }
    
    public static ArrayList<Integer> getGcd(int[] arr, ArrayList<Integer> gcds ){
        
        if(gcds.isEmpty()){
            for(int i=2; i<=arr[0]; i++){
                if(arr[0] % i ==0){
                    gcds.add(i);
                }
            }
            Collections.sort(gcds, Collections.reverseOrder());
            return gcds;
        }
        
        int gcdIdx = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int gcd : gcds){
            boolean flag = true;
            for(int i=1; i<arr.length; i++){
                if(arr[i] % gcd !=0){
                    flag= false;
                    break;
                }
            }
            if(flag){
                temp.add(gcd);
            }
        }
        Collections.sort(temp, Collections.reverseOrder());
        
        return temp;
    }
    
}