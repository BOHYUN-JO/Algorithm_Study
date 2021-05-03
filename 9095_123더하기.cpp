#include <cstdio>

using namespace std;

int d[11] = {0,};

int dp(int n){
	int i;
	
}

int main(){
	int i,j,T, n, sum;
	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	
	for(i=4; i<11; i++){
		sum = 0;
		for(j=1; j<4; j++){
			sum += d[i-j];
		}
		d[i] = sum;
	}
	
	scanf("%d", &T);
	for(i=0; i<T; i++){
		scanf("%d", &n);
		printf("%d\n", d[n]);
	}
	 
}
