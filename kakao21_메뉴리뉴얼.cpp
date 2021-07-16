#include <string>
#include <vector>
#include <algorithm>
#include <map>
#include <iostream>

using namespace std;

map<string, int> combination(vector<string> orders, int course){
    vector<int> ind;
    map<string, int> m;
    
    for(int i=0; i<orders.size(); i++){        
        if(orders[i].length() < course){
            continue;
        }
        
        for(int j=0; j<course; j++){    // »ÌÀ» °³¼ö
            ind.push_back(1);
        }
        sort(orders[i].begin(), orders[i].end());
        
        for(int j=0; j< orders[i].length()-course; j++){
            ind.push_back(0);
        }
        sort(ind.begin(), ind.end());
        
        do{
            string temp = "";
            for(int j =0 ; j< ind.size(); j++){
                if(ind[j] == 1){
                    temp += orders[i][j];
                }
            }
            if(m.find(temp) != m.end()){
                m[temp] += 1;
            }else{
                m[temp] = 1;
            }
        }while(next_permutation(ind.begin(), ind.end()));
        ind.clear();
    }
    
    return m;
    
}

vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> answer;
    map<string, int> m;
    string temp = "";
    int maxCnt = 0;
    for(int i=0; i<course.size(); i++){
        maxCnt = 0;
        m = combination(orders, course[i]);
        for(auto iter = m.begin() ; iter != m.end(); iter++){
            if(maxCnt < iter->second){
                maxCnt = iter->second;
            }
        }
        for(auto iter = m.begin() ; iter != m.end(); iter++){
            if(maxCnt > 1 && maxCnt == iter->second){
                answer.push_back(iter->first);
            }
        }
    }
    sort(answer.begin(), answer.end());
    
    return answer;
}
