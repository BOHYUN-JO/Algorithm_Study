#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int ad[360000];

// string to time
int str2time(string str){
    int ret = 0;
    int temp;
    temp = stoi(str.substr(0,2));
    ret += temp*60*60;
    temp = stoi(str.substr(3,2));
    ret += temp*60;
    temp = stoi(str.substr(6,2));
    ret += temp;
    
    return ret;
}

// int to string
string int2str(int adv_start){
    string answer = "";    
    int hour = adv_start/3600; adv_start %=3600;
    int _min = adv_start/60; adv_start %=60;
    int sec = adv_start;
     if(hour / 10 < 1) answer += "0" + to_string(hour) +":";
     else answer += to_string(hour) + ":";
            
     if(_min/10 < 1) answer += "0" + to_string(_min) + ":";
     else answer += to_string(_min) + ":";
            
     if(sec/10 <1) answer += "0" + to_string(sec);
     else answer += to_string(sec);
    
    return answer;
}

string solution(string play_time, string adv_time, vector<string> logs) {
    string answer = "";
    
    for(string s : logs){
        int start = str2time(s.substr(0,8));
        int end = str2time(s.substr(9,8));
        for(int i=start; i<end; i++) ad[i]++;
    }
    
    int N = str2time(play_time);
    int len = str2time(adv_time);
    
    int idx = 0;
    long long sum = 0;
    long long maxSum = 0;
    
    queue<int> q;
    
    for(int i=0; i<len; i++){
        sum += ad[i];
        q.push(ad[i]);
    }
    maxSum = sum;
    
    for(int i=len ; i<N; i++){
        sum += ad[i];
        q.push(ad[i]);
        sum -= q.front();
        q.pop();
        if(sum > maxSum){
            idx = i-len+1;
            maxSum = sum;
        }
    }
    
    answer = int2str(idx);
    
    return answer;
}
