#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> play_time;
vector<string> title;
vector<string> sheet;

int getTime(string& str){
    string temp = "";
    int start = 0;
    int end = 0;
    temp = str.substr(0,2);
    start = stoi(temp)*60;
    
    temp = "";
    temp = str.substr(3,2);
    start += stoi(temp);
    
    temp = "";
    temp = str.substr(6,2);
    end = stoi(temp)*60;
   
    temp = "";
    temp = str.substr(9,2);
    end += stoi(temp);
    
    return end-start;
}

string changeString(string str){
    string temp = "";
    for(int i=0; i<str.length(); i++){
        if(str[i] == '#'){
            if(str[i-1] == 'C'){
                temp[temp.length()-1] = 'c';
            }else if(str[i-1] =='D'){
                temp[temp.length()-1] = 'd';
            }else if(str[i-1] == 'F'){
                temp[temp.length()-1] = 'f';
            }else if(str[i-1] == 'G'){
                temp[temp.length()-1] = 'g';
            }else if(str[i-1] == 'A'){
                temp[temp.length()-1] = 'h';
            }else if(str[i-1] == 'E'){
                temp[temp.length()-1] = 'e';
            }
        }else{
            temp += str[i];
        }
    }
    return temp;
}

string solution(string m, vector<string> musicinfos) {
    string answer = "";
    string title_temp = "";
    string sheet_temp = "";
    m = changeString(m);
    int max_time = 0;
    
    for(int i=0; i<musicinfos.size(); i++){
        musicinfos[i] = changeString(musicinfos[i]);
        play_time.push_back(getTime(musicinfos[i]));
        title_temp = "";
        sheet_temp = "";
        int j;
        for(j=12; j<musicinfos[i].length(); j++){
            if(musicinfos[i][j] == ','){
                break;
            }
            title_temp += musicinfos[i][j];
        }
        title.push_back(title_temp);
        
        for(int k=j+1; k<musicinfos[i].length(); k++){
            if(sheet_temp.length() >= play_time[i]){
                break;
            }
            sheet_temp += musicinfos[i][k];
        }
        while(sheet_temp.length() < play_time[i]){
            sheet_temp += sheet_temp;
        }
        sheet.push_back(sheet_temp);
    }
    
    for(int i=0; i<sheet.size(); i++){
        cout << sheet[i] << endl;
        if(sheet[i].find(m) != string::npos){
            if(max_time < play_time[i]){
                max_time = play_time[i];
                answer = title[i];
            }
        }
    } 
    
    if(answer == ""){
        answer = "(None)";
    }
    
    return answer;
}
