#include <iostream>
#include <cmath>
#include <cstring>

using namespace std;

long long arr[5][5];
long long ans[5][5];


void dnc(int n, long long b){
	long long t = b;
	long long temp[5][5] = {0,};
	for(int i=0; i<n; i++){
		ans[i][i] = 1;
	}
	while(t){
		if(t%2 == 1){
			for(int i=0; i<n; i++){
				for(int j=0; j<n ; j++){
					for(int k=0; k<n ; k++){
						temp[i][j] += ans[i][k]*arr[k][j];
					}
					temp[i][j] %= 1000;
				}
			}
			for(int i=0; i<n; i++){
				for(int j=0; j<n ; j++){
					ans[i][j] = temp[i][j];
				}
			}
		}
		t /= 2;
		memset(temp,0, sizeof(temp));
		for(int i=0; i<n; i++){
			for(int j=0; j<n ; j++){
				for(int k=0; k<n ; k++){
					temp[i][j] += arr[i][k]*arr[k][j]; 
				}
				temp[i][j] %= 1000;
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n ; j++){
				arr[i][j] = temp[i][j];
			}
		}
		memset(temp,0, sizeof(temp));
	}
}

int main(){
	int n;
	long long b;
	cin >> n >> b;
	for(int i=0; i<n; i++){
		for(int j=0; j<n ; j++){
			cin >> arr[i][j];
		}
	}
	
	dnc(n,b);
	
	for(int i=0; i<n ; i++){
		for(int j=0; j<n; j++){
			cout << ans[i][j] << " ";
		}
		cout << '\n';
	}
	return 0;
}
