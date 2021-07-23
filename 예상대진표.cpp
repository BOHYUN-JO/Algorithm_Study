#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 1;
    if(a > b){
        int tmp = a;
        a= b;
        b= tmp;
    }
    while(1){
        if( b-a == 1 && a%2 == 1 && b%2 == 0){
            break;
        }else{
            if(a%2 == 0){
                a /= 2;
            }else{
                a /= 2;
                a += 1;
            }
            
            if(b%2 == 0){
                b /=2;
            }else{
                b /= 2;
                b += 1;
            }
            answer++;
        }
    }

    return answer;
}
