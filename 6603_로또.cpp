#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int k;

void combi(vector<int>& v, int idx, int depth, vector<bool>& check, vector<int>& ans){
	if(depth == 6){
		for(int i=0; i<6; i++){
			cout << ans[i] << ' ';
		}
		cout << endl;
		return;
	}
	else{
		for(int i=idx; i<k; i++){
			if(!check[i]){
				check[i] = true;
				ans[depth] = v[i];
				combi(v,i,depth+1, check, ans);
				check[i] = false;
			}
		}
	}
}

int main(){
	while(true){
		cin >> k;
		if(k==0) break;
		vector<int> v;
		vector<int> ans(k,0);
		vector<bool> check(k, false);
		for(int i=0; i<k; i++){
			int tmp;
			cin >> tmp;
			v.push_back(tmp);
		}
		combi(v, 0, 0, check, ans);
		cout << endl;
	} 
}

