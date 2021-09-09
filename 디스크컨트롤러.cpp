#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

struct cmp{
    bool operator()(pair<int,int> a, pair<int,int> b){
        return a.second > b.second;
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    int sum = 0, start,end,cur,idx=1;
    priority_queue<pair<int,int>,vector<pair<int,int>>, cmp> pq;
    
    sort(jobs.begin(), jobs.end());
    
    pq.push({jobs[0][0], jobs[0][1]});
    cur=jobs[0][0];
    while(!pq.empty()){
        start = pq.top().first;
        end = pq.top().second;
        pq.pop();
        cur += end;
        sum += (cur-start);
        for(;idx<jobs.size(); idx++){
            if(jobs[idx][0] > cur) break;
            pq.push({jobs[idx][0], jobs[idx][1]});
        } 
        
        if(pq.empty() && idx<jobs.size()){
            cur = jobs[idx][0];
            pq.push({jobs[idx][0],jobs[idx][1]});
            idx++;
            
        }
    }
    
    return sum/jobs.size();
}
