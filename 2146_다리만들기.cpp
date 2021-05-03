#include <cstdio>
#include <queue>
#include <utility>
#include <algorithm>
#include <vector>
using namespace std;


int arr[100][100];
int mx[4] = { -1,0,1,0 };
int my[4] = { 0,-1,0,1 };
int edge = 2;
int check[101][101] = { 0, };
vector<pair <int, int> > v;
int mini = 100;

void clear(int n) {
	int i, j;
	for (i = 0; i < n + 1; i++) {
		for (j = 0; j < n + 1; j++) {
			check[i][j] = 0;
		}
	}
}

void bfs(int i, int j, int n) {
	int y, x, k, ny, nx;
	queue<pair<int, int> > q;

	q.push(make_pair(i, j));
	check[i][j] = 1;
	while (!q.empty()) {
		y = q.front().first;
		x = q.front().second;
		q.pop();
		for (k = 0; k < 4; k++) {
			ny = y + my[k];
			nx = x + mx[k];
			if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
				continue;
			}
			if (arr[ny][nx] == 0) {
				arr[y][x] = edge;
				v.push_back(make_pair(y, x));
			}

			if (arr[ny][nx] == 1 && check[ny][nx] == 0) {
				q.push(make_pair(ny, nx));
				check[ny][nx] = 1;
			}
		}
	}
	edge++;
}

int dist(int i, int j, int n) {
	int start = arr[i][j];
	arr[i][j] = -1;
	int y, x, k, ny, nx, cnt = 0, cy,cx;
	queue<pair<pair<int, int> , int > > q;
	priority_queue<int, vector<int>, greater<int> > pq;
	q.push(make_pair(make_pair(i, j), 0));
	check[i][j] = 1;
	while (!q.empty()) {
		y = q.front().first.first;
		x = q.front().first.second;
		cnt = q.front().second;
		if (cnt > mini) {
			return 1000;
		}
		q.pop();
		for (k = 0; k < 4; k++) {
			ny = y + my[k];
			nx = x + mx[k];
			if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
				continue;
			}
			if (arr[ny][nx] != 0 && arr[ny][nx] != start && arr[ny][nx] != -1 && arr[ny][nx]!= 1) {
				pq.push(cnt);
			}
			if (check[ny][nx] == 0 && arr[ny][nx] == 0) {
				q.push(make_pair(make_pair(ny,nx), cnt+1));
				check[ny][nx] = 1;
			}
		}
	}
	
	return pq.top();
}


int main() {
	int n, i, j, y, x;

	queue<int> q;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
		}
	}

	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			if (check[i][j] == 0 && arr[i][j] == 1) {
				bfs(i, j, n);
			}
		}
	}
	
	for (i = 0; i < v.size(); i++) {
		clear(n);
		y = v[i].first;
		x = v[i].second;
		if (arr[y][x] != -1) {
			mini = min(mini, dist(y, x, n));
		}
	}

	printf("%d", mini);

	return 0;
}
