#include <iostream>
#include <string>

using namespace std;

int solution(string s)
{
    int answer=1;
    for(int i=1; i<s.length(); i++){
        int temp = 1;
        int left = i-1;
        int right = i+1;
        while(left >=0 && right < s.length()){
            if(s[left] == s[right]){
                temp+=2;
                left--;
                right++;
            }else break;
        }
        if(temp > answer) answer = temp;
    }
    for(int i=0; i<s.length()-1; i++){
        int temp = 0;
        int left = i;
        int right = i+1;
        while(left >=0 && right < s.length()){
            if(s[left] == s[right]){
                temp+=2;
                left--;
                right++;
            }else break;
        }
        if(temp > answer) answer = temp;
    } 
    
    return answer;
}
