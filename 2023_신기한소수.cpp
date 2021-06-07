#include <iostream>
#include <cmath>

using namespace std;

int isPrime(int num){
	if(num <=1){
		return 0;
	}
	int half = num /2;
	for(int i= 2; i<= half ; i++){
		if(num%i == 0){
			return 0;
		}
	}
	
	return 1;
}

int promising1(int num, int low){
	int tmp;
	while(1){
		num %=low;
		low /=10;
		if(num <=0 || low <=0){
			break;
		}
		tmp = num / low;
		if(tmp %2 == 0){
			return 0;
		}
		
	}
	
	return 1;	
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n, low, high, tlow;
	cin >> n;
	low = pow(10,n-1);
	high = pow(10,n);
	
	for(int i= low; i<high; i++){
		int tmp = i / low;
		if(tmp == 1 || tmp == 4 || tmp == 6 || tmp == 8 || tmp == 9){
			i = i+ low-1;
			continue;
		}
		if(promising1(i, low)){
			tlow = low;
			while(1){
				if(!isPrime(i/tlow)){
					break;
				}
				tlow /= 10;
				if(tlow == 0){
					cout << i << '\n';
					break;
				}
			}
		}	
	}
	
	return 0;
}
