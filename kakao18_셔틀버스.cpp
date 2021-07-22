#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> arrive_time;

void convertTime(vector<string> timetable){
    string hour = "";
    string min = "";
    
    for(int i=0; i<timetable.size(); i++){
        hour = timetable[i].substr(0,2);
        min = timetable[i].substr(3,2);
        int tmp = stoi(hour)*60 + stoi(min);
        arrive_time.push_back(tmp);
    }
}

string solution(int n, int t, int m, vector<string> timetable) {
    string answer = "";
    string hh = "";
    string mm = "";
    int start = 540;
    int ans = 0;
    int idx = 0;
    int hour, min;
    convertTime(timetable);
    sort(arrive_time.begin(), arrive_time.end());
    
    for(int i=0; i<n; i++){
        int full = m;
        for(int j = idx; j<arrive_time.size(); j++){
            if(arrive_time[j] <= start){
                idx++;
                full--;
                if(full ==0) break;
            }
            
        }
        
        if(i+1 == n){
            if(full == 0){
                ans = arrive_time[idx-1] - 1;
            }else{
                ans = start;
            }
        }
        
        start += t;
    }
    
    hour = ans / 60;
    min = ans % 60;
    hh = to_string(hour);
    mm = to_string(min);
     
    if(hh.length() == 1){
        answer += "0";
        answer += hh;
    }else{
        answer += hh;
    }
    answer += ":";
    if(mm.length() == 1){
        answer += "0";
        answer += mm;
    }else{
        answer += mm;
    }
    
    return answer;
}
