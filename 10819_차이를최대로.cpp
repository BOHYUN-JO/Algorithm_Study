#include <iostream>
#include <algorithm> 
#include <vector>
#include <cmath>

using namespace std;

vector<int> v;
int tmax = 0;

int main(){
	int n, k;
	cin >> n;
	
	for(int i=0; i<n; i++){
		cin >>k;
		v.push_back(k);
	}
	sort(v.begin(), v.end());
	
	do{
		int sum =0;
		for(int i=1; i<n; i++){
			sum += abs(v[i-1]-v[i]);
		}
		if(sum > tmax){
			tmax = sum;
		}
	}while(next_permutation(v.begin(), v.end()));
	
	cout << tmax << endl;
	
	return 0;
}
