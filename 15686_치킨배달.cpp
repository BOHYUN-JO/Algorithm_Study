#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath> 

using namespace std;

int main(){
	int N,M, chicken=0;
	int arr[51][51];
	cin >> N >> M;
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++){
			cin >> arr[i][j];
			if(arr[i][j] == 2) chicken++;
		}
	}	
	
	
	
	return 0;
}
