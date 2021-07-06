#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321

using namespace std;

typedef long long ll;

int n, m;
 
int prices[2501];
ll costs[2501][2501]; // 1에서 j까지 기름값 k로 가는 비용  
vector<vector<pair<int, int> > > edges;
 
 
ll dijkstra(){
    
    for(int i=0; i<=n; i++){
        for(int j=0; j<=2500; j++){
            costs[i][j] = INF;
        }
    }
    
    priority_queue<pair<ll, pair<int, int> > > pq; // cost, node, gas price
    pq.push({0, {1, prices[1]}});
    
    while(!pq.empty()){
        int node = pq.top().second.first;
        ll cost = -pq.top().first;
        int price = pq.top().second.second;
        pq.pop();
        
        if(costs[node][price] < cost) continue;
        if(node == n) return cost; // 목적지에 도달했으면 종료. 우선순위 큐를 이용했기 때문에 최소 비용이 된다. 
        
        for(int i=0; i<edges[node].size(); i++){
            int next_node = edges[node][i].first;
            ll next_cost = cost + edges[node][i].second * price;
            int next_price = min(price, prices[next_node]);
            
            if(costs[next_node][price] > next_cost){
                costs[next_node][price] = next_cost;
                pq.push({-next_cost, {next_node, next_price}});
            }
        }
    }
}
 
int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    
    edges.resize(n+1); 
    
    for(int i=1; i<=n; i++){
        cin >> prices[i];
    }
    
    int a, b, c;
    for(int i=0; i<m; i++){
        cin >> a >> b >> c;
        edges[a].push_back({b,c});
        edges[b].push_back({a,c});
    }
    
    cout << dijkstra();
}

