#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int MAX = 999999999;
int T, R, C, N, r, c;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs(char** board, vector<pair<int,int>>& horses, vector<vector<int>>& score, int r, int c) {
    queue<pair<int, int>> q;
    q.push(make_pair(r, c));
    
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 1 || ny < 1 || nx > R || ny > C) continue;
            if (score[nx][ny] > score[cur.first][cur.second] + 1 && board[nx][ny] == '.') {
                score[nx][ny] = score[cur.first][cur.second] + 1;
                q.push(make_pair(nx, ny));
            }
        }
    }

    int sum = 0;
    for (pair<int, int> horse : horses) {
        if (score[horse.first][horse.second] == MAX) return MAX;
        sum += score[horse.first][horse.second];
    }

    return sum;
}

int main() {
    cin >> T;
    while (T-- > 0) {
        cin >> R >> C >> N >> r >> c;
        vector<pair<int,int>> horses;
        vector<pair<int,int>> walls;

        for (int i = 0; i < N; i++) {
            int x, y;
            cin >> x >> y;
            horses.push_back(make_pair(x, y));
        }

        char** board = new char*[R + 1];
        vector<vector<int>> score(R + 1, vector<int>(C + 1, MAX));

        for (int i = 1; i <= R; i++) {
            board[i] = new char[C + 1];
            string str;
            cin >> str;
            for (int j = 1; j <= C; j++) {
                board[i][j] = str[j - 1];
                if (str[j - 1] == 'W') {
                    walls.push_back(make_pair(i, j));
                }
            }
        }

        score[r][c] = 0;
        int D = bfs(board, horses, score, r, c);
        int ans = 0;

        for (pair<int, int> wall : walls) {
            vector<vector<int>> score_copy = score; // 간단하게 벡터 복사로 대체
            board[wall.first][wall.second] = '.';

            int min = MAX;
            pair<int, int> minXY;
            for (int i = 0; i < 4; i++) {
                int nx = wall.first + dx[i];
                int ny = wall.second + dy[i];
                if (nx < 1 || ny < 1 || nx > R || ny > C) continue;
                if (board[nx][ny] == '.' && min > score[nx][ny]) {
                    min = score[nx][ny];
                    minXY = make_pair(nx, ny);
                }
            }

            int d = bfs(board, horses, score_copy, minXY.first, minXY.second);
            board[wall.first][wall.second] = 'W';
            if (d != MAX) {
                ans += D - d;
            }
        }

        cout << D << ' ' << ans << endl;

        for (int i = 1; i <= R; i++) {
            delete[] board[i];
        }
        delete[] board;
    }
}