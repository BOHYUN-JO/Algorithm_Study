#include <iostream>

using namespace std;


int main(){
	ios::sync_with_stdio(false);
    cin.tie(NULL);	
	
	int n, k;
	
	cin >> n >> k;
	
	int low =1, high = k, ans;
	
	while(low<=high){
		long long cnt = 0;
		int mid = (low+high)/2;
		for(int i=1; i<=n; i++){
			cnt += std::min(mid/i, n);
		}
		if(cnt <k){
			low = mid +1;
		}else{
			ans = mid;
			high = mid -1;
		}
	}
	
	cout << ans;
	
	return 0;
}

