#include <string>
#include <vector>
#include <iostream>

using namespace std;

int zip(string str, int unit){
    string zip_str = "";
    string prev = str.substr(0 , unit);
    string cur = "";
    int len = str.length();
    int cnt = 1;
    for(int i=unit; i<len; i+= unit){
        cur = "";
        for(int j=i; j<len && j<i+unit; j++){
            cur += str[j];
        }
        if(cur == prev){
            cnt++;
        }else{
            if(cnt != 1){
                zip_str += to_string(cnt) + prev;
            }else{
                zip_str += prev;
            }
            prev = cur;
            cnt = 1;
        }
    }
    
    if(cnt != 1){
        zip_str += to_string(cnt) + cur;
    }else{
        zip_str += cur;
    }
    
    return zip_str.length();
}

int solution(string s) {
    int answer = s.length();    
    int iter = s.length()/2;
    for(int i=1; i <= iter; i++){
        int cnt = zip(s,i);
        if(answer > cnt){
            answer = cnt;
        }
    }
        
    return answer;
}
