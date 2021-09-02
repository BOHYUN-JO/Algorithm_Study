#include <iostream>
#include<vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> board)
{

    int map[1000][1000];
int row;
int col;
int dp[1000][1000];


    row = board.size();
    col = board[0].size();

    for (int i = 0; i < row; i++) {
        for (int k = 0; k < col; k++) {
            map[i][k] = board[i][k];
            dp[i][k] = board[i][k];
        }
    }
    int answer = map[0][0];


    for (int i = 1; i < row; i++) {
        for (int k = 1; k < col; k++) {
            if (map[i][k] == 1) {
                dp[i][k] = min({ dp[i - 1][k - 1], dp[i - 1][k] ,dp[i][k - 1] }) + 1;
                if (answer < dp[i][k])
                    answer = dp[i][k];
            }
        }
    }

    return answer*answer;
}
