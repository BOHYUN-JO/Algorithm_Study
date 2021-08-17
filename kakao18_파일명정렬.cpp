#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> parsing(string str){
    vector<string> ret;
    int i;
    string temp = "";
    for(i=0; i<str.length(); i++){
        if(str[i] <='9' && str[i] >='0'){
            break;
        }else{
            temp += str[i];
        }
    }
    ret.push_back(temp);
    temp = "";
    for(; i<str.length(); i++){
        if(str[i] <='9' && str[i] >= '0'){
            temp += str[i];
        }else break;
    }
    ret.push_back(temp);
    
    return ret;
}

bool compare(string str1, string str2){
    vector<string> parse1 = parsing(str1);
    vector<string> parse2 = parsing(str2);
    string comp1 = parse1[0];
    string comp2 = parse2[0];
    int cmp1 = stoi(parse1[1]);
    int cmp2 = stoi(parse2[1]);
    
    transform(comp1.begin(), comp1.end(), comp1.begin(), ::tolower);
    transform(comp2.begin(), comp2.end(), comp2.begin(), ::tolower);
    
    if(comp1 > comp2){
        return true;
    }else if(comp1 < comp2){
        return false;
    }else{
        if(cmp1 > cmp2) return true;
    }
    
    
    return false;
    
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    string temp = "";
    for(int i=0; i < files.size() ; i++){ // bubble sort
        for(int j=0; j<files.size()-i-1; j++){
            if(compare(files[j] , files[j+1])){    // swap
                temp = files[j];
                files[j] = files[j+1];
                files[j+1] = temp;
            }
        }
    }
    answer = files;
    
    return answer;
}
