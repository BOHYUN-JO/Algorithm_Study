#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

map<string,int> m; 

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    int cnt = 1;
    int level = 1;
    char last;
    bool flag = true;
    
    m[words[0]] = 1;
    last = words[0][words[0].length()-1];
        
    for(int i=1; i< words.size(); i++){
        if(last != words[i][0]){
            answer.push_back(i%n+1);
            answer.push_back(level);
            flag = false;
            break;
        }else if(m.find(words[i]) != m.end()){
            answer.push_back(i%n+1);
            answer.push_back(level);
            flag = false;
            break;
        }else{
            m[words[i]] = 1;
            last = words[i][words[i].length()-1];
            cnt++;
            if(cnt == n){
                cnt = 0;
                level++;
            }
        }
    }
    
    if(flag){
        answer.push_back(0);
        answer.push_back(0);
    }
    
    return answer;
}
