#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
 
#define endl "\n"
#define MAX 1010
using namespace std;
 
int N, M;
int Dist[MAX];
int Parent[MAX];
vector<pair<int, int>> V[MAX];
 
void Dijkstra(int Start)
{
    for (int i = 1; i <= N; i++) Dist[i] = 2e9;
    Dist[Start] = 0;
    priority_queue<pair<int, int>> PQ;
    PQ.push(make_pair(0, Start));
    
    while (PQ.empty() == 0)
    {
        int Cost = PQ.top().first;
        int Cur = PQ.top().second;
        PQ.pop();
 
        for (int i = 0; i < V[Cur].size(); i++)
        {
            int Next = V[Cur][i].first;
            int nCost = V[Cur][i].second;
 
            if (Dist[Next] > Cost + nCost)
            {
                Dist[Next] = Cost + nCost;
                Parent[Next] = Cur;
                PQ.push(make_pair(Dist[Next], Next));
            }
        }
    }
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 	cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b, c; cin >> a >> b >> c;
        V[a].push_back(make_pair(b, c));
        V[b].push_back(make_pair(a, c));
    }
 
    Dijkstra(1); 
    cout << N - 1 << endl;
    for (int i = 2; i <= N; i++)
    {
        cout << Parent[i] << " " << i << endl;
    }
 
    return 0;
}


