#include <string>
#include <vector>
#include <iostream>

using namespace std;

string convert(int n, int num){
    string ret = "";
    int tmp = 0; 
    char temp = 'A';
    if(num == 0) return "0";
    
    while(num > 0){
        tmp = num % n;
        if(tmp >= 10){
            temp = tmp-10+'A';
            ret = temp + ret;
        }else{
            ret = to_string(tmp) +ret;
        }
        num/= n;
    }
    
    return ret;
}

string solution(int n, int t, int m, int p) {
    string answer = "";
    string temp = "";
    
    int len = t*m;
    int num = 0;
    while(temp.length() < len){
        temp += convert(n,num++);
    }
    
    for(int i=0; i<t; i++){
        answer += temp[m*i+p-1];
    }
                
    return answer;
}
