#include <string>
#include <vector>

using namespace std;

string dec2bin(int n){
    string ret = "";
    while (n != 0){
        ret += ( n % 2 == 0 ? "0" : "1" );
        n /= 2;
    }
    return ret;
}

vector<int> solution(string s) {
    vector<int> answer;
    string temp = s;
    int zero_cnt = 0;
    int iter_cnt = 0;
    int len = 0;
    
    while(1){
        len = 0;
        for(int i=0; i<temp.length(); i++){
            if(temp[i] == '0'){
                zero_cnt++;
            }else{
                len++;
            }
        }
        iter_cnt++;
        temp = dec2bin(len);
        if(len == 1) break;
    }
    
    answer.push_back(iter_cnt);
    answer.push_back(zero_cnt);
    
    return answer;
}
