#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;
int n,m;

int binary_search(int low, int high){
	int sum, mid;
	
	while(low+1 < high){
		mid = (low+high)/2;
		sum =0;
		for(int i=0; i<n; i++){
			if(v[i] < mid)
				sum += v[i];
			else
				sum += mid;
		}
		
		if(sum <= m){
			low = mid;
		}else{
			high = mid;
		}
	}
	
	return low;
		
}

int main(){
	int tmp,sum=0;
	cin >> n;
	for(int i=0; i<n ; i++){
		cin >> tmp;
		v.push_back(tmp);
		sum += tmp;
	} 
	cin >> m;
	sort(v.begin(), v.end());
	
	if(sum <= m){
		cout << v[n-1] << endl;
	}else{
		cout << binary_search(0,m) << endl;
	}
		
	return 0;
}
