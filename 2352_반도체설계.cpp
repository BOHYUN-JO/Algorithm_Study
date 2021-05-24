#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> v;


int main(){
	int n,temp,cnt=0;
	cin >> n;
	v.push_back(0);
	
	for(int i=0; i< n; i++){
		cin >> temp;
		if(temp > v.back()){
			v.push_back(temp);
			cnt++;
		}
		else{
			vector<int>::iterator low = lower_bound(v.begin(), v.end(), temp);
			*low = temp;
		}	
		
	}
	
	cout << cnt;
			
	
	return 0;
} 
