#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int n,s,k,cnt =0;
	
	cin >> n >> s;
	for(int i=0; i<n ; i++){
		cin >> k;
		v.push_back(k); 
	}
	
	for(int i=1; i<=n; i++){
		vector<bool> b(n-i, false);
		b.insert(b.end(), i, true);
		do{
			int temp = 0;
			for(int k=0; k < n; k++){
				if(b[k]){
					temp += v[k];
				}
			}
			if(temp == s){
				cnt ++;
			}
		}while(next_permutation(b.begin(), b.end()));
	}
	
	cout << cnt << endl;
	
	return 0;
}
