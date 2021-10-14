#include <bits/stdc++.h>

using namespace std;

struct Que {
	int x;
	int y;
};

vector<Que> board[101][101];
bool light[101][101];
bool vis[101][101];

int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };

int main()
{
	int N, M;
	int a, b, c, d;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		cin >> a >> b >> c >> d;
		board[a - 1][b - 1].push_back({c-1,d-1});
	}

	while (1) {
		memset(vis, false, sizeof(vis));
		queue<Que> Q;
		Q.push({ 0,0 });
		vis[0][0] = true;
		light[0][0] = true;
		bool flag = false;
		while (!Q.empty()) {
			auto cur = Q.front();
			Q.pop();
			if (!board[cur.x][cur.y].empty()) {
				for (int i = 0; i < board[cur.x][cur.y].size(); i++) {
					auto c = board[cur.x][cur.y][i];
					light[c.x][c.y] = true;
				}
				board[cur.x][cur.y].clear();
				flag = true;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx<0 or nx>N - 1 or ny<0 or ny>N - 1)continue;
				if (light[nx][ny] == true and vis[nx][ny] == false) {
					Q.push({ nx,ny });
					vis[nx][ny] = true;
				}
			}
		}
		if (!flag) {
			break;
		}
	}
	int cnt = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (light[i][j])cnt++;
		}
	}
	
	cout << cnt << endl;
}
