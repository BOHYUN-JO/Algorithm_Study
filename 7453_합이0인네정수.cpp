#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long a[4000];
long long b[4000];
long long c[4000];
long long d[4000];

vector<long long> v;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	long long low, high, half;
	int n;
	cin >> n;
	for(int i=0; i<n; i++){
		cin >> a[i] >> b[i] >> c[i] >> d[i];
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n ; j++){
			v.push_back(c[i] + d[j]);
		}
	}
	sort(v.begin(), v.end());
	long long ret = 0;
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			half = a[i] + b[j];
			low = lower_bound(v.begin(), v.end(), -half) - v.begin();
			high = upper_bound(v.begin(), v.end(), -half) - v.begin();
			
			if(-half == v[low]){
				ret += (high-low);
			}
		}
	}
	
	cout <<ret<< endl;
	return 0;
}
