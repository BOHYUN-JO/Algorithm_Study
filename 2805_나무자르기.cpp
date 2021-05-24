#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;

int main() {
	long long n, m, tmp, len, low, mid, high;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		v.push_back(tmp);
	}
	len = v.size();

	sort(v.begin(), v.end());
	low = 0;
	high = v[len - 1];

	while (low + 1 < high) {
		mid = (low + high) / 2;
		long long sum = 0;
		for (int i = 0; i < len; i++) {
			if(v[i] - mid > 0)
				sum += v[i] - mid;
		}

		if (sum < m) {
			high = mid;
		}
		else {
			low = mid;
		}
	}

	cout << low << endl;

	return 0;
}
