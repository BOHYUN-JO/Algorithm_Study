#include <iostream>
#include <vector>

using namespace std;

int main(){
	int i, N, tmp, min;
	unsigned long long int sum = 0;
	vector<long long int> len;
	vector<long long int> cost;
	cin >> N;
	for(i=0; i<N-1; i++){
		cin >> tmp;
		len.push_back(tmp);
	}
	for(i=0; i< N; i++){
		cin >> tmp;
		cost.push_back(tmp);
	}
	
	min = cost[0];
	
	for(i=1 ; i<N; i++){
		if(min >= cost[i]){
			sum += min * len[i-1];
			min = cost[i];
			continue;
		}
		sum += min * len[i-1];
	}
	
	cout<< sum << endl;
}
