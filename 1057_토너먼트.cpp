#include <iostream>

using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n,a,b,cnt=1;
	
	cin >> n >> a >> b;
	while(1){
		if(a<b){
			if(a%2 == 1 && b%2 == 0 && b-a == 1){
				break;
			}
		}else{
			if(b%2 == 1 && a%2 == 0 && a-b == 1){
				break;
			}
		}
		
		if(a%2 ==0){
			a /= 2;
		}else{
			a /= 2;
			a += 1;
		}
		
		if(b%2 == 0){
			b /= 2;
		}else{
			b /= 2;
			b += 1;
		}
		cnt++;
	}
	
	cout << cnt << endl;
	
	return 0;
}
