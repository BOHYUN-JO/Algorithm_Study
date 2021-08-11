#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <stack>

using namespace std;

int check(vector<int>& a, int most){
    stack<int> st;
    int cnt = 0;
    for(int i=0; i<a.size(); i++){
        if(a[i] == most){
            if(st.empty()){
                st.push(most);
            }else{
                if(st.top() == most) continue;
                while(!st.empty()){
                    st.pop();
                }
                cnt++;
            }
        }else{
            if(!st.empty() && st.top() == most){
                st.pop();
                cnt++;
            }else{
                st.push(a[i]);
            }
        }
    }
    
    return cnt*2;
}

int solution(vector<int> a) {
    int answer = -1;
    int most = 0;
    int tmax = 0;
    int temp = 0;
    map<int, int> m;
    
    if(a.size() < 2) return 0;
    
    for(int i=0; i<a.size(); i++){
        if(m.find(a[i]) != m.end()){
            m[a[i]] += 1;
        }else{
            m[a[i]] = 1;
        }
    }
    
    for(const auto& item : m){
        if(item.second < (tmax/2) ) continue;
        temp = check(a, item.first);
        if(temp > tmax) tmax = temp;
        
    }
    
    answer = tmax;
    
    return answer;
}
