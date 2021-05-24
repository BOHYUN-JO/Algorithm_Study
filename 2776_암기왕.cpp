#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;



bool bsearch(int start, int end, int target, vector<int> &v)
{
    if (start > end)
		return false;
    int  mid = (start + end) / 2;
    
    if (v[mid] == target)
		return true;
    else if (v[mid] < target)
		return bsearch(mid + 1, end, target, v);
    else 
		return bsearch(start, mid - 1, target, v);
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int t,n,m,k;
	cin >> t;
	while(t--){
		vector<int> v;
		cin >> n;
		for(int i=0; i<n; i++){
			cin >> k;
			v.push_back(k);
		}
		sort(v.begin(), v.end());
		cin >> m;
		for(int i=0; i<m ; i++){
			cin >> k;
			if(bsearch(0, v.size()-1, k, v)){
				cout << "1\n";
			}else{
				cout << "0\n";
			}
		}
	
	}
	
	return 0;
}
