#include <bits/stdc++.h>

using namespace std;

int main(){
	
	deque<int> dq;
	int n;
	cin >> n;
	for(int i=1; i<=n; i++){
		dq.push_back(i);
	}
	
	while(1){
		if(dq.size() >1){
			dq.pop_front();
			int tmp = dq.front();
			dq.push_back(tmp);
			dq.pop_front();
		}else{
			cout << dq.front();
			break;
		}
	}
	
	return 0;
}
