#include <string>
#include <vector>
#include <iostream>

using namespace std;

int dec2bin(int n){
    int cnt = 0;
    while(n>0){
        if(n%2 == 1) cnt++;
        n /=2;
    }
   
    return cnt;
}

int solution(int n) {
    int answer = 0;
    int cnt = dec2bin(n);
    int tmp=n;
    while(1){
        tmp++;
        if(dec2bin(tmp) == cnt){
            break;
        }
    }
    
    
    return tmp;
}
