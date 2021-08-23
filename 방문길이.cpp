#include <string>
using namespace std;

int solution(string dirs) {
    int answer = 0;
    int y = 5;
    int x = 5;
    int ny,nx;
    int board[11][11][4];
    for(int i=0; i<11; i++){
        for(int j=0; j<11; j++){
            for(int k=0; k<4; k++){
                board[i][j][k] = 0;    
            }
        }
    }
    for(int i=0; i<dirs.length(); i++){
        if(dirs[i] == 'L'){
            ny = y; nx = x-1;
            if(ny<0 || nx <0 || ny >10 || nx >10) continue;
            if(board[ny][nx][1] == 0){
                answer++;
                board[ny][nx][1] = 1;
                board[y][x][3] = 1;
            }    
        }else if(dirs[i] == 'R'){
            ny = y; nx = x+1;
            if(ny<0 || nx <0 || ny >10 || nx >10) continue;
            if(board[ny][nx][3] == 0){
                answer++;
                board[ny][nx][3] = 1;
                board[y][x][1] = 1;
            } 
        }else if(dirs[i] == 'U'){
            ny = y-1; nx = x;
            if(ny<0 || nx <0 || ny >10 || nx >10) continue;
            if(board[ny][nx][0] == 0){
                answer++;
                board[ny][nx][0] = 1;
                board[y][x][2] = 1;
            } 
        }else{  // "D"
            ny = y+1; nx = x;
            if(ny<0 || nx <0 || ny >10 || nx >10) continue;
            if(board[ny][nx][2] == 0){
                answer++;
                board[ny][nx][2] = 1;
                board[y][x][0] = 1;
            } 
        }
        x=nx; y=ny;
        
    }
    return answer;
}
