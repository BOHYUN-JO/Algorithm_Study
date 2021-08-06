#include <string>
#include <vector>

using namespace std;

int rotate(vector<vector<int>>& board, int y1, int x1, int y2, int x2){
    int min = 987654321;
    int temp1, temp2;
    
    /* 윗 부분 밀어내기 */
    temp1 = board[y1][x2];
    if(min > temp1) min = temp1;
    for(int i=x2; i>x1; i--){
        board[y1][i] = board[y1][i-1];
        if(min > board[y1][i]) min = board[y1][i];
    }
    
    /* 오른쪽 부분 밀어내기 */
    temp2 = board[y2][x2];
    if(min > temp2) min = board[y2][x2];
    for(int i=y2; i>y1+1; i--){
        board[i][x2] = board[i-1][x2];
        if(min > board[i][x2] ) min = board[i][x2];
    }
    board[y1+1][x2] = temp1;
    
    /* 아랫 부분 밀어내기 */
    temp1 = board[y2][x1];
    if(min > temp1) min = temp1;
    for(int i=x1; i<x2-1; i++){
        board[y2][i] = board[y2][i+1];
        if(min > board[y2][i]) min = board[y2][i];
    }
    board[y2][x2-1] = temp2;
    
    /* 왼쪽 부분 밀어내기 */
    for(int i=y1; i<y2-1; i++){
        board[i][x1] = board[i+1][x1];
        if(min > board[i][x1]) min = board[i][x1];
    }
    board[y2-1][x1] = temp1;
    
    return min;
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    vector<vector<int>> board;
    for(int i=1; i<=rows; i++){
        vector<int> inner;
        for(int j=1; j<=columns; j++){
            inner.push_back((i-1)*columns + j);
        }
        board.push_back(inner);
    }
    
    for(int i=0; i<queries.size(); i++){
        answer.push_back(rotate(board,queries[i][0]-1,queries[i][1]-1,queries[i][2]-1, queries[i][3]-1));   
    }
    
    return answer;
}
