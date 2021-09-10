#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath> 

using namespace std;

int main(){
	int N, tmp, total=0, tmax=0, tmin=1e9;
	vector<int> v;
	vector<char> op; 
	char temp[4] = {'+', '-', '*', '/'};
	int opCnt[4]; 
	cin >> N;
	for(int i=0; i<N; i++){
		cin >> tmp;
		v.push_back(tmp);
	}
	for(int i=0; i<4; i++){
		cin >> opCnt[i];
		for(int j=0; j<opCnt[i]; j++){
			op.push_back(temp[i]);
		}
	}
	
	sort(op.begin(), op.end());
	
	do{
		int sum = v[0];
		for(int i=1; i<N; i++){
			if(op[i-1] == '+'){
				sum += v[i];
			}else if(op[i-1] == '-'){
				sum -= v[i];
			}else if(op[i-1] == '*'){
				sum *= v[i];
			}else sum /= v[i];
		}
		if(sum > tmax) tmax = sum;
		if(sum < tmin) tmin = sum;
	}while(next_permutation(op.begin(), op.end()));
	
	cout << tmax << endl;
	cout << tmin << endl;	
	return 0;		
	
}
