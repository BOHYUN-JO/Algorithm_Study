#include <bits/stdc++.h>

using namespace std;

int H,W,X,Y;
int B[601][601];

int main(){
	cin >> H >> W >> X >> Y;
	
	for(int i=0; i<H+X; i++){
		for(int j=0; j<W+Y; j++){
			cin >> B[i][j];
		}
	} 
	
	for(int i=X; i<H+X; i++){
		for(int j=Y; j<W+Y; j++){
			B[i][j] = B[i][j] - B[i-X][j-Y];
		}
	}
	
	for(int i=0; i<H; i++){
		for(int j=0; j<W; j++){
			cout << B[i][j] << ' ';
		}
		cout << endl;
	}
	
	return 0;
}
