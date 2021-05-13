#include <iostream>
#include <cstring>

using namespace std;

string str[65]; 
char ans[65];
int idx = 0;

void dnc(int len, int x, int y){
	int i,j,flag;
	char start = str[y][x];
	flag = 1;
	for(i=0; i<len; i++){
		for(j=0; j<len; j++){
			if(start != str[y+i][x+j]){
				flag = 0;
				break;
			}
		}
		if(flag == 0){
			break;
		}
	}
	
	if(flag == 1){
		ans[idx++] = start;
	}else{
		ans[idx++] = '(';
		len = len/2;
		dnc(len, x, y);
		dnc(len, x+ len, y);
		dnc(len, x, y+len);
		dnc(len, x+len, y+len);
		ans[idx++] = ')';
	} 
	
}

int main(){
	int n;
	
	cin >> n;
	for(int i=0; i<n ; i++){
		cin >> str[i];
	}
	dnc(n, 0, 0);
	ans[idx] = '\0'; 
	cout << ans << endl;
	return 0;
}
