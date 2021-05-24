#include <iostream>

using namespace std;


int main() {
	long long x,y,z,low,high,mid,temp;
	cin >> x >> y;
	z = 100*y/x;
	if(z>=99){
		cout << -1 << endl;
		return 0;
	}
	
	low = 0;
	high = 1000000000;
	while(low <=high){
		mid = (low+high)/2;
		temp = 100*(y+mid)/(x+mid);
		if(z<temp){
			high = mid-1;
		}else{
			low = mid+1;
		}
	}
	
	cout << low << endl;

	return 0;
}
