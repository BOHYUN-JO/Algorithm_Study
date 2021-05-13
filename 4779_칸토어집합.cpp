#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;

char str[600000];

void dnc(int len, int start){
	int i, end;
	
	if(len == 1){
		return;
	}
	i = start + len/3;
	end = i + len/3;
	for( ; i < end ; i++){
		str[i] = ' ';
	}
	dnc(len/3, start);
	dnc(len/3, end);
	
}

int main(){
	int len,n, i;
	while(cin >> n){
		len = pow(3, n);
		for(i=0; i< len; i++){
			str[i] = '-';
		}
		str[i]= '\0';
		dnc(len, 0);
		cout << str << endl;
	}

	return 0;
}
