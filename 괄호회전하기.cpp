#include <string>
#include <vector>
#include <stack>

using namespace std;

bool check(vector<char>& v, int len, int idx){
    stack<char> st;
    for(int i=0; i<len; i++){
        if(v[idx+i] == '{' || v[idx+i] == '[' || v[idx+i] == '(' ){
            st.push(v[idx+i]);
        }else{
            if(st.empty()){
                return false;
            }
            else if(v[idx+i] == '}'){
                if(st.top() != '{'){
                    return false;
                }else st.pop();
            }else if(v[idx+i] == ']'){
                if(st.top() != '['){
                    return false;
                }else st.pop();
            }else{
                if(st.top() != '('){
                    return false;
                }else st.pop();
            }
        }
        
    }
    
    if(!st.empty()){
        return false;
    }else return true;
}

int solution(string s) {
    int answer = 0;
    vector<char> v;
    for(int i=0; i<s.length(); i++){
        v.push_back(s[i]);
    }
    for(int i=0; i<s.length(); i++){
        v.push_back(s[i]);
        if(check(v, s.length(), i)) answer++;
    }       
    
    return answer;
}
