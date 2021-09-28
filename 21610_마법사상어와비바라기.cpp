#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int N, M, ny, nx;
	int A[51][51];
	int my[9] = { 0,0,-1,-1,-1,0,1,1,1 };
	int mx[9] = { 0,-1,-1,0,1,1,1,0,-1 };
	vector<pair<int, int> > cloud;
	bool check[51][51];

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
	}
	int d, s;

	cloud.push_back({ N - 1,0 }); cloud.push_back({ N - 1,1 });
	cloud.push_back({ N - 2,0 }); cloud.push_back({ N - 2,1 });

	for (int i = 0; i < M; i++) {
		cin >> d >> s;
		fill(check[0], check[51], false);
		for (int j = 0; j < s; j++) {
			for (auto& it : cloud) {
				ny = it.first + my[d];
				nx = it.second + mx[d];
				if (ny < 0) ny = N - 1;
				if (nx < 0) nx = N - 1;
				if (ny >= N) ny = 0;
				if (nx >= N) nx = 0;
				it.first = ny;
				it.second = nx;
			}
		}
		for (auto& it : cloud) {
			A[it.first][it.second] += 1;
			check[it.first][it.second] = true;
		}

		for (auto& it : cloud) {
			for (int j = 2; j <= 8; j += 2) {
				ny = it.first + my[j];
				nx = it.second + mx[j];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if (A[ny][nx] > 0) {
					A[it.first][it.second] += 1;
				}
			}
		}

		
		cloud.clear();

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (!check[j][k]) {
					if (A[j][k] >= 2) {
						cloud.push_back({ j,k });
						A[j][k] -= 2;
					}
				}
			}
		}

	}

	int sum = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			sum += A[i][j];
		}
	}

	cout << sum << endl;

	return 0;
}
