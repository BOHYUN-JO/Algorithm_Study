#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> parse(string str){
    string temp = "";
    vector<string> ret;
    for(int i=0; i<str.length()-1; i++){
        temp = str.substr(i,2);
        if( (temp[0] >= 'a' && temp[0] <='z') && (temp[1] >='a' && temp[1] <='z') ){
            ret.push_back(temp);
        }        
    }   
    return ret;
}

int countIntersection(vector<string> s1, vector<string> s2){
    int cnt = 0;
    for(int i=0; i<s2.size(); i++){
        auto it = find(s1.begin(), s1.end(), s2[i]);
        if(it != s1.end()){
            cnt++;
            s1.erase(it);
        }
    }
    
    return cnt;
}

int solution(string str1, string str2) {
    int answer = 0;
    double tmp;
    int union_cnt = 0;
    int intersection_cnt = 0;
    
    string temp = "";
    vector<string> s1, s2;
    
    /* 소문자로 변환 */
    transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
    transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
    
    /* 두 글자씩 parsing */
    s1 = parse(str1);
    s2 = parse(str2);
    
    if(s1.size()==0 && s2.size() ==0){  // 둘 다 공집합이면
        return 65536;
    }
    
    /* 교집합 count */
    if(s1.size() > s2.size()){
        intersection_cnt = countIntersection(s1,s2);
    }else{
        intersection_cnt = countIntersection(s2,s1);
    }
    
    /* 합집합 = s1+s2-교집합 */
    union_cnt = s1.size() + s2.size() - intersection_cnt;
    
    /* 자카드 유사도 계산 */
    tmp = (double)intersection_cnt/(double)union_cnt;
    answer = tmp*65536;
    
    return answer;
}
