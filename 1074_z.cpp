#include <iostream>
#include <cmath>

using namespace std;

int idx = 0;
int n,r,c;
int ans;

void dnc(int y, int x, int len, int start){
	if(y == r && x == c){
		ans = start;
		return;
	}
	len = len/2 ;
	if(r < y+len && c < x+len){ // left up 
		dnc(y,x, len, start);
	}else if(r < y+len && c >= x+len){ // right up
		dnc(y,x+len, len, start + (len)*(len) );
	}else if(r >= y+len && c < x+len){
		dnc(y+len,x, len, start + 2*(len)*(len) );
	}else{
		dnc(y+len,x+len, len, start + 3*(len)*(len) );
	}
	
}

int main(){
	int len;
	cin >> n >> r >> c;
	len = pow(2,n);
	dnc(0,0,len, 0);
	
	cout<< ans << endl;
	
	return 0; 
}
