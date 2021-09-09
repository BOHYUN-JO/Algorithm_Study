#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    int dist[20001];
    vector<int> v[20001];
    priority_queue<pair<int,int>> pq;
    
    for(int i=0; i<edge.size(); i++){
        v[edge[i][0]].push_back(edge[i][1]);
        v[edge[i][1]].push_back(edge[i][0]);
    }
    
    fill(dist, dist+20000, 1e9);    
    
    pq.push({0,1});
    dist[1] = 0;    
    
    while(!pq.empty()){
        int cost = -pq.top().first;
        int cur = pq.top().second;
        pq.pop();
        
        for(int i=0; i<v[cur].size(); i++){
            int next = v[cur][i];
            int nCost = 1;
            
            if(dist[next] > cost + nCost){
                dist[next] = cost + nCost;
                pq.push({-dist[next], next});
            }
        }
    }
    
    int tmax=0;
    for(int i=1; i<=n; i++){
        if(tmax < dist[i]){
            tmax = dist[i];
        }
    }
    
    for(int i=1; i<=n; i++){
        if(tmax == dist[i]) answer++;
    }
    
    return answer;
}
