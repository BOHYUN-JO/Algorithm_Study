#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>
#define pp pair<string,int>

using namespace std;

bool cmp(const pp& a, const pp& b) {
	if (a.second == b.second) return a.first < b.first;
	return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map<string, int> m;
    map<string, vector<int>> m2;
    
    for(int i=0; i<genres.size(); i++){
        if( m.find(genres[i]) != m.end() ){
            m[genres[i]] += plays[i];
            if(m2[genres[i]].size() == 1){
                m2[genres[i]].push_back(i);
                if(plays[m2[genres[i]].at(0)] < plays[m2[genres[i]].at(1)]){
                    int tmp = m2[genres[i]].at(1);
                    m2[genres[i]].at(1) = m2[genres[i]].at(0);
                    m2[genres[i]].at(0) = tmp;
                }
            }else{
                if( plays[m2[genres[i]].at(0)] < plays[i] ){
                    m2[genres[i]].at(1) = m2[genres[i]].at(0);
                    m2[genres[i]].at(0) = i;
                }else{
                    if( plays[m2[genres[i]].at(1)] < plays[i] ){
                        m2[genres[i]].at(1) = i;
                    }
                }
            }
        }else{
            m[genres[i]] = plays[i];
            m2[genres[i]].push_back(i);
        }
    }
    
    vector<pp> v(m.begin(), m.end());
    sort(v.begin(), v.end(), cmp);
    
    for(auto it : v){
        answer.push_back(m2[it.first].at(0));
        if(m2[it.first].size() > 1){
            answer.push_back(m2[it.first].at(1));
        }
    }
    
    return answer;
}
