#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> v[1500];

int parsing(string s){
    bool paren_flag = false;
    int idx = 0;
    int len = s.length();
    string mem = "";
    vector<int> temp;
    for(int i=1; i < len-1; i++){
        if(s[i] == '{'){
            temp.clear();
            paren_flag = true;
        }else if(s[i] == '}'){
            temp.push_back(stoi(mem));
            mem = "";
            for(auto c : temp){
                v[temp.size()].push_back(c);
            }
            idx++;
            paren_flag = false;
        }else if(s[i] ==','){
            if(paren_flag){
                temp.push_back(stoi(mem));
                mem = "";
            } 
        }else{
            mem += s[i];
        } 
    }
    
    return idx;
}

vector<int> solution(string s) {
    vector<int> answer;
    int size = parsing(s);
    for(int i=1; i<= size; i++){
        for(auto it : v[i]){
            if(find(answer.begin(), answer.end(), it) == answer.end()){
                answer.push_back(it);
            }
        }
    }   
    
    return answer;
}
