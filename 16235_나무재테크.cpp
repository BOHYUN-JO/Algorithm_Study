#include <iostream>
#include <vector>
#include <algorithm>
#include <deque>


using namespace std;

typedef struct _Tree {
	int y;
	int x;
	int age;
	bool alive;
	bool on;
}Tree;


bool cmp(Tree a, Tree b) {
	return a.age < b.age;
}

int main() {
	int N, M, K;
	int A[11][11];
	int land[11][11];
	deque<Tree> v;
	int my[8] = { 0,-1,-1,-1,0,1,1,1 };
	int mx[8] = { -1,-1,0,1,1,1,0,-1 };

	cin >> N >> M >> K;
	fill(land[0], land[11], 5);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> A[i][j];
		}
	}

	for (int i = 0; i < M; i++) {
		Tree tree;
		cin >> tree.y >> tree.x >> tree.age;
		tree.y -= 1; tree.x -= 1;
		tree.alive = true;
		tree.on = true;
		v.push_back(tree);
	}
	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < K; i++) {
		// spring
		for (int j = 0; j < v.size(); j++) {
			int y = v[j].y;
			int x = v[j].x;
			if (land[y][x] < v[j].age) {
				v[j].alive = false;
			}
			else {
				land[y][x] -= v[j].age;
				v[j].age += 1;
			}
		}
		//summer
		deque<Tree>::iterator it;
		for (it = v.begin(); it != v.end();it++) {
			if (!it->alive && it->on) {
				land[it->y][it->x] += it->age / 2;
				it->on = false;
			}
		}
		//fall
		for (int j = 0; j < v.size(); j++) {
			if (v[j].alive && v[j].age % 5 == 0) {
				for (int k = 0; k < 8; k++) {
					int ny = v[j].y + my[k];
					int nx = v[j].x + mx[k];
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					Tree tree;
					tree.y = ny; tree.x = nx; tree.age = 1; tree.alive = true;
					v.push_front(tree);
					j++;
				}
			}
		}
		// winter
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				land[j][k] += A[j][k];
			}
		}

	}
	int ans = 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i].alive) ans++;
	}

	cout << ans;

	return 0;
}
