#include <string>
#include <vector>
#include <queue>
#include <iostream>
 
#define HORIZONTAL 0
#define VERTICAL 1
 
using namespace std;
 
typedef struct Robot {
    int row;
    int col;
    int dir;
    int time;
    Robot(int r, int c, int d, int t) { row = r; col = c; dir = d; time = t; }
}Robot;
 
int dir_row[4] = {1,0,-1,0};
int dir_col[4] = {0,-1,0,1};
int turn_row[2][4] = { {0,0,-1,-1},{1,1,0,0} };
int turn_col[2][4] = { {0,1,0,1},{0,-1,0,-1} };
int visited[2][101][101];
 
queue<Robot> q;
 
bool checkEnd(Robot cur,int n) {
    if (cur.dir == HORIZONTAL) {
        if (cur.row == n - 1 && cur.col + 1 == n - 1)
            return true;
    }
    else {
        if (cur.row + 1 == n - 1 && cur.col == n - 1)
            return true;
    }
    return false;
}
 
//���� ������, ���϶� false ��ȯ
bool canMoveNext(int r, int c, int d,vector<vector<int>> board) {
    int b_size = board.size();
    if (r < 0 || r >= b_size|| c < 0 || c >= b_size)
        return false;
    if (board[r][c] == 1)
        return false;
    if (d == HORIZONTAL) {
        if (c + 1 >= b_size || board[r][c+1] ==1)
            return false;
    }
    else {
        if (r + 1 >= b_size || board[r + 1][c] == 1)
            return false;
    }
    return true;
}
 
//ȸ���� ������ ������, ȸ�� �߰��� ���������� üũ
bool canTurnRobot(Robot cur, int next_row, int next_col, vector<vector<int>> board) {
    int b_size = board.size();
    if (cur.dir == HORIZONTAL) { // ��->��
        if (cur.row == next_row) { //�Ʒ��� ������ ȸ��
            if (cur.row + 1 >= b_size)//���� �����
                return false;
            if (board[cur.row + 1][cur.col] || board[cur.row + 1][cur.col + 1]) //���� �ϳ��� ���϶�
                return false;
        }
        else { // ���� ������ ȸ��
            if (cur.row - 1 < 0)
                return false;
            if (board[cur.row - 1][cur.col] || board[cur.row - 1][cur.col + 1])
                return false;
        }
    }
    else {// ��->��
        if (cur.col == next_col) {//���������� ������ ȸ��
            if (cur.col + 1 >= b_size)
                return false;
            if (board[cur.row][cur.col + 1] || board[cur.row + 1][cur.col + 1])
                return false;
        }
        else {
            if (cur.col - 1 < 0)
                return false;
            if (board[cur.row][cur.col - 1] || board[cur.row + 1][cur.col - 1])
                return false;
        }
    }
    return true;
}
 
int solution(vector<vector<int>> board) {
     q.push(Robot(0, 0, HORIZONTAL, 0));
 
    while (!q.empty()) {
        Robot cur = q.front();
        q.pop();
        
        if (checkEnd(cur, board.size())) {
            return cur.time;
        }
        //ȸ�� ���� �ʰ� �׹��� �̵�
        for (int i = 0; i < 4; i++) { 
            int next_row = cur.row + dir_row[i];
            int next_col = cur.col + dir_col[i];
 
            if (!canMoveNext(next_row, next_col, cur.dir, board))
                continue;
            if (!visited[cur.dir][next_row][next_col]) {//�湮 ���߾��ٸ�
                visited[cur.dir][next_row][next_col] = 1;
                q.push(Robot(next_row, next_col, cur.dir, cur.time + 1));
            }
        }
        //ȸ��
        for (int i = 0; i < 4; i++) { //4���� ����� ȸ��
            int next_dir = cur.dir ^ 1; //xor������ ���� ���� ������
            int next_row = cur.row + turn_row[cur.dir][i];
            int next_col = cur.col + turn_col[cur.dir][i];
    
 
            if (!canTurnRobot(cur, next_row, next_col, board))
                continue;
            if (!visited[next_dir][next_row][next_col]) {
                visited[next_dir][next_row][next_col] = 1;
                q.push(Robot(next_row, next_col, next_dir, cur.time + 1));
            }
        }
    }
}
