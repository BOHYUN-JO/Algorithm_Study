#include <string>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct{
    string cmd;
    int num;
}item;

item parsing(string& str){
    string temp="";
    item ret;
    ret.cmd = str[0];
    for(int i=2; i<str.length(); i++){
        temp += str[i];
    }
    ret.num = stoi(temp);
    
    return ret;
}

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    vector<int> pq;
    for(int i=0; i<operations.size(); i++){
        item temp = parsing(operations[i]);
        if(temp.cmd == "I"){
            pq.push_back(temp.num);
            sort(pq.begin(), pq.end());
        }else if(temp.cmd =="D"){
            if(temp.num == 1){
                if(!pq.empty()){
                     pq.erase(pq.begin()+(pq.size()-1));
                }
            }else{
                if(!pq.empty()){
                    pq.erase(pq.begin());
                }
            }
        }
    }
    
    if(pq.size() == 0){
        answer.push_back(0);
        answer.push_back(0);
    }else if(pq.size()==1){
        answer.push_back(pq[0]);
        answer.push_back(pq[0]);
    }else{
        answer.push_back(pq[pq.size()-1]);
        answer.push_back(pq[0]);
    }
        
    return answer;
}
