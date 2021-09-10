#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string new_id) {
    string answer = new_id;
    
    /*1단계*/
    transform(answer.begin(), answer.end(), answer.begin(), ::tolower);
    /*2단계, 3단계*/
    string temp = "";
    for(int i=0; i<answer.length(); i++){
        if( (answer[i]>='a' && answer[i]<='z') || (answer[i]>='0'  &&answer[i]<='9') || answer[i] == '-' || answer[i] == '_'){
            temp += answer[i];
        }else if(answer[i] == '.'){
            if(temp[temp.length()-1] != '.') temp += answer[i];
        }
    }
    
    while(temp[0] == '.'){
        temp = temp.substr(1,temp.length()-1);
    }
    
    if(temp[temp.length()-1] == '.'){
        temp = temp.substr(0,temp.length()-1);
    }
    if(temp.length() == 0){
        temp += 'a';    
    }else if(temp.length() >= 16){
        temp = temp.substr(0,15);
    }
    
    if(temp[temp.length()-1] == '.'){
        temp = temp.substr(0,temp.length()-1);
    }
    
    if(temp.length() <=2){
        while(temp.length()<=2){
            temp += temp[temp.length()-1];
        }
    }
    
    answer = temp;
    return answer;
}
