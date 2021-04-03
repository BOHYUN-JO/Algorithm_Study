#include <iostream>
#include <stack>
#include <memory.h>
#include <utility>

using namespace std;

 
int main(){
	int M,N,i,j,cnt = 0;
	int arr[252][252];
	int check[252][252];
	stack< pair<int,int> > st;
	pair<int, int> p;
	
	for(i=0; i<252 ; i++){
		for(j=0; j<252; j++){
			check[i][j] = 0;
		}
	}
	
	cin >> M >> N;
	for(i=0; i<=M; i++){
		arr[0][i] = 0;
		arr[M+1][i] = 0;
	}
	for(i=1; i<=N; i++){
		arr[i][0] = 0;
		arr[i][N+1] = 0;
	}
	for(i=1; i<=M; i++){
		for(j=1; j<=N; j++){
			cin >> arr[i][j];
		}
	}
	
	for(i=1; i<=M; i++){
		for(j=1; j<=N; j++){
			if(arr[i][j] == 1 && check[i][j] == 0){
				st.push(make_pair(i,j));
				while(!st.empty()){
					p = st.top();
					st.pop();
					if(arr[p.first-1][p.second-1] == 1 && check[p.first-1][p.second-1] == 0){
						check[p.first-1][p.second-1] = 1;
						st.push(p);
						st.push(make_pair(p.first-1, p.second-1));
						continue;
					}else if(arr[p.first-1][p.second] == 1 && check[p.first-1][p.second] == 0){
						check[p.first-1][p.second]= 1;
						st.push(p);
						st.push(make_pair(p.first-1, p.second));
						continue;
					}else if(arr[p.first-1][p.second+1] == 1 && check[p.first-1][p.second+1] == 0){
						check[p.first-1][p.second+1] = 1;
						st.push(p);
						st.push(make_pair(p.first-1, p.second+1));
						continue;
					}else if(arr[p.first][p.second-1] == 1 && check[p.first][p.second-1] == 0){
						check[p.first][p.second-1] = 1;
						st.push(p);
						st.push(make_pair(p.first, p.second-1));
						continue;
					}else if(arr[p.first][p.second+1] == 1 && check[p.first][p.second+1] == 0){
						check[p.first][p.second+1] = 1;
						st.push(p);
						st.push(make_pair(p.first, p.second+1));
						continue;
					}else if(arr[p.first+1][p.second-1] == 1 && check[p.first+1][p.second-1] == 0){
						check[p.first+1][p.second-1] = 1;
						st.push(p);
						st.push(make_pair(p.first+1, p.second-1));
						continue;
					}else if(arr[p.first+1][p.second] == 1 && check[p.first+1][p.second] == 0){
						check[p.first+1][p.second] = 1;
						st.push(p);
						st.push(make_pair(p.first+1, p.second));
						continue;
					}else if(arr[p.first+1][p.second+1] == 1 && check[p.first+1][p.second+1] == 0){
						check[p.first+1][p.second+1] = 1;
						st.push(p);
						st.push(make_pair(p.first+1, p.second+1));
						continue;
					}else continue;
					
				}
				cnt++;
			}
			
		}
	}
	
	cout<< cnt <<endl;
	
	return 0;
	
}
