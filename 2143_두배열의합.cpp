#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

int A[1000];
int B[1000];
int T, n, m;
vector<int> v,w;

int main(){
	ios::sync_with_stdio(false);
    cin.tie(NULL);	
	cin >> T;
	cin >> n;
	for(int i=0; i < n ; i++){
		cin >> A[i];
	}
	cin >> m;
	for(int i=0; i < m ; i++){
		cin >> B[i];
	}
	
	for(int i=0; i<n; i++){
		int sum = A[i];
		v.push_back(sum);
		for(int j= i+1; j<n; j++){
			sum += A[j];
			v.push_back(sum);
		}
	}
	
	for(int i=0; i<m; i++){
		int sum = B[i];
		w.push_back(sum);
		for(int j=i+1 ; j<m; j++){
			sum += B[j];
			w.push_back(sum);
		}
	}
	
	sort( w.begin(), w.end() );
	
	ll ans = 0;
	for(auto item : v){
		int diff = T - item;
		auto ub = upper_bound(w.begin(), w.end(), diff);
		auto lb = lower_bound(w.begin(), w.end(), diff);
		ans += (ub-lb);
	}
	
	cout << ans;
	
	return 0;
}
