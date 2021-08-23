#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> tree[300001];
bool visited[300001];

long long solution(vector<int> b, vector<vector<int>> edges) {
    long long answer = 0;
    vector<long long> a(b.size());
    for(int i=0; i<b.size(); i++){
        a[i] = (long long)b[i];
    }
    // 0으로 만들 수 있는지 체크
    long long sum = 0;
    for (int i=0; i<a.size(); i++){
        sum += (long long)a[i];
    }
    if( sum != 0 ) return -1;


    // 트리 구성
    for (int i=0; i<edges.size(); i++ ){
        int n1 = edges[i][0];
        int n2 = edges[i][1];
        tree[n1].push_back(n2);
        tree[n2].push_back(n1);
    }

    queue<int> q;
    int* nodes = new int[a.size()];
    for (int i=0; i<a.size(); i++){
        nodes[i] = tree[i].size();
        if( nodes[i] == 1 ) q.push(i);
    }

    while(!q.empty()){
        int cur = q.front();
        long long curWeight = (long long)a[cur];
        q.pop();
        visited[cur] = true;
        for (int i=0; i<tree[cur].size(); i++){
            int next = tree[cur][i];
            if(!visited[next]){
                a[cur] -= curWeight;
                a[next] += curWeight;
                answer += abs(curWeight);
                nodes[next]--;
                if(nodes[next] == 1) 
                    q.push(next); 
            }
            
        }
    }

    return answer;
}
