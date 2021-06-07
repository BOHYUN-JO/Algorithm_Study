#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;


int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	string str;
	int cnt = 0;
	cin >> str;	
	
	sort(str.begin(), str.end());
	do{
		int flag = 1;
		for(int i=1; i<str.length()-1; i++){
		    if(str[i-1] == str[i] || str[i] == str[i+1]){
                flag = 0;
                break;
            }	
		}
		if(flag) cnt++;
	}while(next_permutation(str.begin(), str.end()));
	
	cout << cnt << endl;
	return 0;
}
