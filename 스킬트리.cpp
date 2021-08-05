#include <string>
#include <vector>
#include <deque>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    bool flag = true;
    deque<char> check;
    deque<char> temp;
    for(int i=0; i<skill.length() ; i++){
        temp.push_back(skill[i]);
    }
    
    for(int i=0; i<skill_trees.size(); i++){
        check = temp;
        flag = true;
        for(int j=0; j<skill_trees[i].length(); j++){
            if(find(check.begin(), check.end(), skill_trees[i][j]) != check.end()){
                   if(check.front() != skill_trees[i][j]){
                       flag = false;
                       break;
                   }else{
                       check.pop_front();
                   }
            }else{
                flag = true;
            }
        }
        if(flag){
            answer++;
        }
    }    
    
    return answer;
}
