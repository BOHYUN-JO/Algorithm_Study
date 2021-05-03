#include <cstdio>
#include <queue>
#include <utility>
#include <stack>

using namespace std;

int main() {
	int N, M, i, j, ny, nx, x, y, cnt = 0;
	int maze[100][100];
	char temp[101];
	int visit[100][100] = { 0, };
	int mx[4] = { -1,0,1,0 };
	int my[4] = { 0,-1,0,1 };
	pair<int, int> parent[100][100];
	stack< pair<int, int> > st;
	queue< pair<int, int> > q;

	scanf("%d %d", &N, &M);
	for (i = 0; i < N; i++) {
		scanf("%s", temp);
		for (j = 0; j < M; j++) {
			maze[i][j] = temp[j] - '0';
		}
	}

	q.push(make_pair(0, 0));
	visit[0][0] = 1;
	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();
		if (y == N - 1 && x == M - 1) {
			break;
		}
		for (i = 0; i < 4; i++) {
			nx = x + mx[i];
			ny = y + my[i];
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
				continue;
			}
			if (maze[ny][nx] == 1 && visit[ny][nx] == 0) {
				parent[ny][nx] = make_pair(x, y);
				visit[ny][nx] = 1;
				q.push(make_pair(nx, ny));
			}
		}
	}

	st.push(make_pair(M-1, N-1));
	while (!st.empty()) {
		cnt++;
		x = st.top().first;
		y = st.top().second;
		if (x == 0 && y == 0) {
			break;
		}
		st.pop();
		st.push(parent[y][x]);
	}

	printf("%d", cnt);
	return 0;
}