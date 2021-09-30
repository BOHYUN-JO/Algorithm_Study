#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>


using namespace std;

int my[4] = { -1,1,0,0 };
int mx[4] = { 0,0,-1,1 };

int bfs(vector<vector<int> > v, vector<pair<int, int> > onVirus) {
	queue<vector<int> > q;
	bool visited[51][51];
	fill(visited[0], visited[51], false);
	int tmax = 0;

	for (int i = 0; i < onVirus.size(); i++) {
		vector<int> temp;
		temp.push_back(onVirus[i].first);
		temp.push_back(onVirus[i].second);
		temp.push_back(0);
		q.push(temp);
		visited[onVirus[i].first][onVirus[i].second] = true;
	}

	while (!q.empty()) {
		int y = q.front().at(0);
		int x = q.front().at(1);
		int cost = q.front().at(2);
		q.pop();
		
		v[y][x] = cost;

		for (int i = 0; i < 4; i++) {
			int ny = y + my[i];
			int nx = x + mx[i];
			if (ny < 0 || nx < 0 || ny >= v.size() || nx >= v.size()) continue;
			if (!visited[ny][nx] && (v[ny][nx] == -2 || v[ny][nx] == -1)) {
				visited[ny][nx] = true;
				vector<int> temp;
				if (v[ny][nx] == -2) {
					if (cost+1 > tmax) tmax = cost+1;
				}
				temp.push_back(ny);
				temp.push_back(nx);
				temp.push_back(cost + 1);
				q.push(temp);
			}
		}
	}

	for (int i = 0; i < v.size(); i++) {
		for (int j = 0; j < v.size(); j++) {
			if (v[i][j] == -2) return -1;
		}
		
	}

	return tmax;
}

int main() {
	int N, M;
	vector<vector<int> > v;
	vector<pair<int, int> > virus;
	vector<int> ind;
	int tmin = 1e9;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		vector<int> temp;
		for (int j = 0; j < N; j++) {	// -3: º®, -2: ºóÄ­, -1: ºñÈ°¼º, 0: È°¼º 
			int tmp;
			cin >> tmp;
			if (tmp == 0) temp.push_back(-2);
			else if (tmp == 1) temp.push_back(-3);
			else if (tmp == 2) {
				temp.push_back(-1);
				virus.push_back({ i,j });
			}
		}
		v.push_back(temp);
	}

	for (int i = 0; i < M; i++) {
		ind.push_back(1);
	}
	for (int i = 0; i < virus.size() - M; i++) {
		ind.push_back(0);
	}
	sort(ind.begin(), ind.end());

	do {
		vector<pair<int, int> > onVirus;
		for (int i = 0; i < ind.size(); i++) {
			if (ind[i] == 1) {
				onVirus.push_back(virus[i]);
			}
		}
		int tmp = bfs(v, onVirus);

		if (tmp == -1) {
			// nothing
		}
		else if (tmp < tmin) {
			tmin = tmp;
		}

	} while (next_permutation(ind.begin(), ind.end()));

	if (tmin == 1e9) {
		cout << -1 << endl;
	}
	else cout << tmin << endl;

	return 0;
}
