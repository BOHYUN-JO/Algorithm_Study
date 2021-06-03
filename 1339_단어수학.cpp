#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
vector<string> word;
int result = 0;
int alpha[26];	

void cal() {
	for (int i = 0; i < word.size(); i++) {
		int pow = 1;
		for (int j = word[i].size() - 1; j >= 0; j--) {
			int val = word[i][j] - 'A';
			alpha[val] += pow;
			pow *= 10;
		}
	}
	sort(alpha, alpha + 26);
	int num = 9;
	for (int i = 25; i >= 0; i--) {
		if (alpha[i] == 0) break;
		result += (alpha[i] * num);
		num--;
	}
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int num;
	string ss;
	cin >> num;
	for (int i = 0; i < num; i++) {
		cin >> ss;
		word.push_back(ss);
	}
	cal();
	cout << result;
	return 0;
}
