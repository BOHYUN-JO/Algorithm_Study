#include <iostream>
#include <vector>

using namespace std;

vector<int> v;
char ans[4] = {' ', 'm', 'o', 'o'};

char moo(int n){
	int i=0;
	char ret;
	if(n<=3){
		return ans[n];
	}
	while(1){
		if(n <= v[i] ){
			break;
		}
		i++;
	}
	
	n -= v[i-1];
	
	if(n-(i+3) > 0 ){
		ret = moo(n-(i+3));
	}else{
		if(n == 1){
			return 'm';
		}else{
			return 'o';
		}
	}
	
	return ret;
}

int main(){
	
	int n,i=0;
	cin >> n;
	v.push_back(3);
	while(1){
		i++;
		v.push_back(v[i-1]+(i+3)+v[i-1]);
		if(v[i] >= 1000000000){
			break;
		}
	} 
	
	cout<< moo(n) << endl;
	
	
	return 0;
}
