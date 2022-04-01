#include <string>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

string changePos(string str){
    int idx = 0;	// good
    string ret = "";
    stack<char> st;
    int count = 0;
    char third, second, first;
    
    for(int i=0; i<str.length(); i++){
        st.push(str[i]);
        if(st.size() >=3 ){
            third = st.top(); st.pop();
            second = st.top(); st.pop();
            first = st.top(); st.pop();
            if(first == '1' && second == '1' && third == '0'){
                count++;
                continue;
            }else{
                st.push(first);
                st.push(second);
                st.push(third);
            }
        }
    }
    
    if(count == 0){
        return str;
    }
    
    idx = st.size();
    while(!st.empty() && st.top() == '1'){
        idx--;
        ret = st.top() + ret;
        st.pop();
    }
    
    while(!st.empty()){
        ret = st.top() + ret;
        st.pop();
    }
    
    while(count-- > 0){
        ret.insert(idx, "110");
    }
    
    return ret;
}

vector<string> solution(vector<string> s) {
    vector<string> answer;
    for(int i=0; i<s.size(); i++){
        answer.push_back(changePos(s[i]));        
    }
    
    return answer;
}
