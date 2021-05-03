#include <cstdio>
#include <vector>
#include <queue>
 
using namespace std;
vector<int> v[100];
int check[101] = {0,};


int bfs(int a, int b){
	int cur,size, cnt = 0;
	queue<int> q;
	q.push(a);
	check[a] = 1;
	while(!q.empty()){
		size = q.size();
		for(int i=0; i<size; i++){
			cur = q.front();
			q.pop();
			if(cur == b){
				return cnt;
			}
			for(int j=0; j<v[cur].size(); j++){
				if(check[v[cur][j]] == 0){
					q.push(v[cur][j]);
					check[v[cur][j]] = 1;
				}	
			}
		}
		cnt++;
	}
	return -1;
	
}
int main(){
	int n, a, b, r, x, y, i, cnt =0;
	
	
	scanf("%d", &n);
	scanf("%d %d", &a, &b);
	scanf("%d", &r);
	
	for(i = 0; i<r; i++){
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}
	
	printf("%d", bfs(a,b));
	
	return 0;
		
}
