class Solution {
    public int[] solution(long begin, long end) {
        int maxValue = 10000000;
        int b = (int) begin;
        int e = (int) end;

        int[] arr = new int[e-b+1];
        int idx = 0;

        if(b == 1){
            arr[idx++] = 0;
            b++;
        }

        for(int i = b; i <= e; i++) {
            int value = 1;

            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0) {
                    value = i/j;
                    if(value <= maxValue) break;
                    else value = 1;
                }
            }
            
            arr[idx++] = value;
        }

        return arr;
    }
}