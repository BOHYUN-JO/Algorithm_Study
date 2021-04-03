#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	int N,K,tmp, i, sum =0;
	vector<int> v;
	vector<int> v2;
	cin >> N;
	cin >> K;
	for(i=0; i<N; i++){
		cin >> tmp;
		v.push_back(tmp);
	}
	
	sort(v.begin(), v.end());
	for(i=0; i<N-1; i++){
		v2.push_back(v[i+1]-v[i]);
	}
	
	sort(v2.begin(), v2.end(), greater<int>());
	for(i=K-1; i<N-1; i++){
		sum+= v2[i];
	}
	cout << sum << endl;
	
	return 0;
		
}
