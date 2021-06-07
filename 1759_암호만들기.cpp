#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int l,c;
vector<char> v;
vector<int> ind;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	char tmp;
	
	cin >> l >> c;
	
	for(int i=0; i<c ; i++){
		cin >> tmp;
		v.push_back(tmp);
		ind.push_back(1);
	} 
	
	sort(v.begin(), v.end());
	for(int i=0; i<l; i++){
		ind[i] = 0;
	}
	
	do{
		string str = "";
		for(int i=0; i< c; i++){
			if(ind[i] == 0){
				str = str + v[i];
			}
		}
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i=0; i< str.length(); i++){
			if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i'|| str[i] == 'o' || str[i] == 'u')
				cnt1++;
			else cnt2++;
		}
		if(cnt1 < 1 || cnt2 < 2)
			continue;
		cout << str << '\n';
		
	}while(next_permutation(ind.begin(), ind.end()));
	
	return 0;
}
