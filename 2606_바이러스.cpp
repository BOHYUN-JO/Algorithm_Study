#include <iostream>
#include <vector>
#include <stack>
#include <memory.h>
using namespace std;

int main() {
	int N, E, i, tmp, tmp2, cnt = 0;
	stack<int> st;
	cin >> N;
	cin >> E;
	vector< vector<int> > v(N+1);
	int* check = new int[N + 1];
	memset(check, 0, (N + 1) * sizeof(int));
	for (i = 0; i < E; i++) {
		cin >> tmp >> tmp2;
		v[tmp].push_back(tmp2);
		v[tmp2].push_back(tmp);
	}

	st.push(1); // 1번 컴퓨터부터 시작
	check[1] = 1;

	while (!st.empty()) {
		int cur = st.top();
		st.pop();
		for (i = 0; i < v[cur].size(); i++) {
			if (check[v[cur][i]] == 0) {
				check[v[cur][i]] = 1;
				st.push(cur);
				st.push(v[cur][i]);
				cnt++;
				break;
			}
		}

	}

	cout << cnt << endl;

	return 0;
}
