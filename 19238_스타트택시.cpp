#include <iostream>
#include <queue>
#include <algorithm>
#include <set>

using namespace std;

int arr[21][21] ={0,};
int p[21][21]={0,};
set<int> des[21][21];
	
int main() {
	int n, m, e, cur_x, cur_y, left, cost;
	
	int my[4] = { -1,1,0,0 };
	int mx[4] = { 0,0,-1,1 };

	cin >> n >> m >> e;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
		}
	}
	cin >> cur_y >> cur_x;

	int a, b, c, d;
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c >> d;
		p[a][b] = i + 2;
		des[c][d].insert(i+2);
	}

	left = m;

	while (left) {
		queue<vector<int> > q;
		vector<int> v;
		bool visited[21][21];
		fill(visited[0], visited[21], false);
		v.push_back(cur_y); v.push_back(cur_x); v.push_back(0);
		q.push(v);
		v.clear();
		visited[cur_y][cur_x] = true;
		int p_y, p_x, tmin = 1e9;

		while (!q.empty()) {
			cur_y = q.front().at(0);
			cur_x = q.front().at(1);
			cost = q.front().at(2);
			q.pop();
			vector<int> temp;

			if (p[cur_y][cur_x] > 1) {	// passenger
				if (cost < tmin) {
					tmin = cost;
					p_y = cur_y;
					p_x = cur_x;
				}
				else if (cost == tmin) {
					if (p_y > cur_y) {
						p_y = cur_y;
						p_x = cur_x;
					}
					else if (p_y == cur_y) {
						if (p_x > cur_x) {
							p_y = cur_y;
							p_x = cur_x;
						}
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int next_y = cur_y + my[i];
				int next_x = cur_x + mx[i];
				if (next_y<1 || next_x < 1 || next_y >n || next_x >n || arr[next_y][next_x] == 1)
					continue;
				if (!visited[next_y][next_x]) {
					temp.push_back(next_y); temp.push_back(next_x); temp.push_back(cost + 1);
					q.push(temp);
					temp.clear();
					visited[next_y][next_x] = true;
				}
			}
		}
		int tar;
		if (e - tmin < 0) {
			break;
		}
		else {
			e -= tmin;
			tar = p[p_y][p_x];
			p[p_y][p_x] = 0;
			cur_y = p_y;
			cur_x = p_x;
		}

		q = queue<vector<int> >();
		v.clear();
		fill(visited[0], visited[21], false);
		v.push_back(cur_y); v.push_back(cur_x); v.push_back(0);
		q.push(v);
		v.clear();
		visited[cur_y][cur_x] = true;

		bool flag = false;
		while (!q.empty()) {
			cur_y = q.front().at(0);
			cur_x = q.front().at(1);
			cost = q.front().at(2);
			q.pop();
			vector<int> temp;

			if (des[cur_y][cur_x].find(tar) != des[cur_y][cur_x].end()) {
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int next_y = cur_y + my[i];
				int next_x = cur_x + mx[i];
				if (next_y<1 || next_x < 1 || next_y >n || next_x >n || arr[next_y][next_x] == 1)
					continue;
				if (!visited[next_y][next_x]) {
					temp.push_back(next_y); temp.push_back(next_x); temp.push_back(cost + 1);
					q.push(temp);
					temp.clear();
					visited[next_y][next_x] = true;
				}
			}
		}

		if (e - cost < 0) {
			break;
		}else if(!flag){
			break;
		}
		else {
			e -= cost;
			e += cost * 2;
			left--;
		}
	}

	if (left) {
		cout << -1 << endl;
	}
	else {
		cout << e << endl;
	}

	return 0;
}
