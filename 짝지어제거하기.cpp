#include <iostream>
#include <string>
#include <stack>

using namespace std;

stack<char> st;

int solution(string s)
{
    int answer = 0;
    
    for(int i=0; i< s.length(); i++){
        if(st.empty()){
            st.push(s[i]);
            continue;
        }
        
        if(s[i] == st.top()){
            st.pop();
        }else{
            st.push(s[i]);
        }
    }
    
    if(st.empty()){
        answer = 1;
    }
    
    return answer;
}
