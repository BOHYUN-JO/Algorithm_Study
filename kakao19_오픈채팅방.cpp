#include <string>
#include <sstream>
#include <vector>
#include <map>

using namespace std;

map<string, string> user;
vector<string> order;

void enter(string s){
    istringstream ss(s);
    string command;
    string user_id;
    string nickname;
    
    getline(ss, command, ' ');
    getline(ss, user_id, ' ');
    getline(ss, nickname, ' ');
    
    order.push_back(command+' '+user_id);
    user[user_id] = nickname;    
}

void leave(string s){
    order.push_back(s);    
}

void change(string s){
    istringstream ss(s);
    string command;
    string user_id;
    string nickname;
    
    getline(ss, command, ' ');
    getline(ss, user_id, ' ');
    getline(ss, nickname, ' ');
    
    user[user_id] = nickname;
    
}

vector<string> print_order(){
    vector<string> ret;
    for(int i=0; i<order.size(); i++){
        istringstream ss(order[i]);
        string command;
        string user_id;
        getline(ss, command, ' ');
        getline(ss, user_id, ' ');
        if(order[i][0] == 'E'){
            ret.push_back(user[user_id]+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        }else if(order[i][0] == 'L'){
            ret.push_back(user[user_id]+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
        }
    }
    
    return ret;
    
}

vector<string> solution(vector<string> record) {
    vector<string> answer;
    int size = record.size();
    for(int i=0; i<size ; i++){
        if(record[i][0] == 'E'){
            enter(record[i]);
        }else if(record[i][0] == 'L'){
            leave(record[i]);
        }else{
            change(record[i]);
        }
    }
    
    answer = print_order();
    
    return answer;
}
