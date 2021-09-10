#include <bits/stdc++.h>

using namespace std;

int main(){
	int N, K, tmp, lv=0;
	deque<int> dq;
	deque<bool> robot;
	cin >> N >> K;
	for(int i=0; i<N*2; i++){
		cin >> tmp;
		dq.push_back(tmp);
		robot.push_back(false);
	}
	
	while(1){
		lv++;
		int last = dq.back();
		dq.pop_back();
		dq.push_front(last);
		bool lt = robot.back();
		robot.pop_back();
		robot.push_front(lt);
		if(robot[N-1]){
			robot[N-1] = false;
		}
		
		for(int i=N-2; i>=0; i--){
			if(robot[i]){
				if(!robot[i+1] && dq[i+1]>0){
					robot[i+1] = true;
					dq[i+1]--;
					robot[i] = false;
				}
			}
		}
		if(robot[N-1]){
			robot[N-1] = false;
		}
		
		
		if(dq[0] >0){
			robot[0] = true;
			dq[0]--;
		}
		int cnt = 0;
		for(int i=0; i<dq.size(); i++){
			if(dq[i] == 0){
				cnt++;
			}
		}
		
		if(cnt >= K) break;
	}
	
	cout << lv << endl;
	
	return 0;
}
