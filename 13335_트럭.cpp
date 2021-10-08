#include <bits/stdc++.h>

using namespace std;

int main(){
	int n,w,L,tmp,cnt=0,sum=0,idx=0;
	vector<int> v;
	queue<pair<int,int> > q; 
	
	cin >> n >> w >> L;
	for(int i=0; i<n; i++){
		cin >> tmp;
		v.push_back(tmp);
	}
	
	cnt++; idx++;
	sum += v[0];
	q.push({v[0],1});
	
	while(!q.empty()){
		cnt++;
		if( cnt - q.front().second == w ){
			sum -= q.front().first;
			q.pop();
		}
		
		if(idx < v.size() && sum + v[idx] <= L){
			q.push({v[idx],cnt});
			sum += v[idx++];
		}
	}
	cout << cnt << endl;
	
	return 0;
}
