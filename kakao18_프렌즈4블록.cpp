#include <string>
#include <vector>
#include <queue>

using namespace std;

int M, N;
vector<vector<bool>> v;

bool check(int y, int x, vector<string> board) {
    int mx[3] = { 1,1,0 };
    int my[3] = { 0,1,1 };
    char c = board[y].at(x);

    for (int i = 0; i < 3; i++) {
        int nx = x + mx[i];
        int ny = y + my[i];
        if (nx >= N || ny >= M || 
            c != board[ny].at(nx)) {
            return false;
        }
    }

    v[y][x] = true;
    for (int i = 0; i < 3; i++) {
        int nx = x + mx[i];
        int ny = y + my[i];
        v[ny][nx] = true;
    }
    return true;
}

vector<string> erase(vector<string> board) {
    for (int i = 0; i < N; i++) {
        queue<char> q;
        for (int j = M -1; j >= 0; j--) {
            if (v[j][i])
                continue;
            q.push(board[j][i]);
        }
        for (int j = M - 1; j >= 0; j--) {
            if (q.empty())
                board[j][i] = 'x';
            else {
                board[j][i] = q.front();
                q.pop();
            }
        }
    }
    return board;
}

int solution(int m, int n, vector<string> board) {
    M = m;
    N = n;
    int answer = 0;
    bool flag = false;
    while (!flag) {
        v = vector<vector<bool>>(m, vector<bool>(n, false));
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'x') 
                    continue;
                if (check(i, j, board))
                    flag = true;
            }
        }
        if (!flag) break;
        board = erase(board);
        flag = false;
    }

    //answer°è»ê
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 'x')
                answer++;
        }
    }

    return answer;
}


