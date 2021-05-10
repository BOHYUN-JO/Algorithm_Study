#include <cstdio>

using namespace std;

int d[501][2];	
int M[501][501];

int min(int a, int b){
	return a < b ? a : b;
}

int main(){
	int N;
	
	scanf("%d", &N);
	for(int i=1; i<=N; i++){
		scanf("%d %d", &d[i][0] , &d[i][1]);	
	}
	
	for(int i = 1; i < N ; i++){
		for(int j=1; i +j <= N ; j++){
			M[j][i+j] = 987654321;
			for(int k = j; k<=i+j; k++){
				M[j][i+j] = min(M[j][i+j], M[j][k] + M[k+1][i+j]+d[j][0]*d[k][1]*d[i+j][1]);
			
			}
		}
	}
	
	printf("%d", M[1][N]);
	return 0; 
}
