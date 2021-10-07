#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
	int T;
	//	 0 1 2 3 4 5 6 7 8 9 
	string dpMin[101];
	string dpMax[101];

	fill(dpMin, dpMin + 101, 0);
	fill(dpMax, dpMax + 101, 0);

	dpMin[0] = "-1"; dpMin[1] = "-1"; dpMin[2] = "1"; dpMin[3] = "7"; dpMin[4] = "4";
	dpMin[5] = "2";	dpMin[6] = "0"; dpMin[7] = "8";

	dpMax[0] = "-1"; dpMax[1] = "-1"; dpMax[2] = "1"; dpMax[3] = "7"; dpMax[4] = "11";
	dpMax[5] = "71"; dpMax[6] = "111"; dpMax[7] = "711";
	
	for (int i = 8; i < 101; i++) {
		string tmin = "999999999999999999999999999999999999999999999999999999999999999999999999";
		string tmax = "0";
		for (int j = 2; j <= i - 2; j++) {
			string tmp = dpMin[j] + dpMin[i - j];
			if (j == 6) {
				tmp = "6" + dpMin[i - 6];
			}
			if (tmin.length() > tmp.length()) tmin = tmp;
			else if (tmin.length() == tmp.length()) {
				if (tmin > tmp) tmin = tmp;
			}
		}
		dpMin[i] = tmin;
		for (int j = 2; j <= i - 2; j++) {
			string tmp = dpMax[j] + dpMax[i - j];
			if (tmax.length() < tmp.length()) tmax = tmp;
			else if (tmax.length() == tmp.length()) {
				if (tmax < tmp) tmax = tmp;
			}
		}
		dpMax[i] = tmax;
		
	}

	cin >> T;
	while (T--) {
		int n, tmp;
		cin >> n;
		/*가장 작은 수 출력*/
		if (n == 6) cout << 6 << ' ';
		else cout << dpMin[n] << ' ';
		/*가장 큰 수 출력*/
		cout << dpMax[n] << ' ';
		cout << endl;
	}

	return 0;
}
