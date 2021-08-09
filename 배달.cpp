#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(int N, vector<vector<int> > road, int K) {
    int answer = 0;
    int dist[51];
    vector<pair<int,int>> v[51];
    priority_queue<pair<int, int>> pq;
    
    for(int i=0; i<road.size(); i++){
        int a = road[i][0];
        int b = road[i][1];
        int c = road[i][2];
        v[a].push_back({b,c});
        v[b].push_back({a,c});
    }
    
    for(int i=0; i<= N; i++){
        dist[i] = 1e9;
    }
    pq.push({0,1});
    dist[1] = 0;
    
    while(!pq.empty()){
        int cost = -pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        
        for(int i=0; i<v[cur].size(); i++){
            int next = v[cur][i].first;
            int nCost = v[cur][i].second;
            
            if(dist[next] > dist[cur] + nCost){
                dist[next] = dist[cur] + nCost;
                pq.push({-dist[next], next});
            }
        }
    }
    
    for(int i=1; i<=N; i++){
        if(dist[i] <= K) answer++;
    }
    
    return answer;
}
