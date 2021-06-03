#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;



int main(){
	int n;
	vector<int> v;
	cin >> n;
	
	for(int i=0; i<n; i++){
		v.push_back(i+1);
	}	
	
	int len = v.size();
	do{
		for(int i=0; i<len ; i++){
			cout << v[i] << ' ';
		}
		cout << '\n';
	}while(next_permutation(v.begin(), v.end()));
	
	return 0;
}
