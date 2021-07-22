#include <string>
#include <vector>
#include <iostream>

using namespace std;


bool check(int y, int x, vector<string> places){
    int mx[4] = {-1,0,1,0};
    int my[4] = {0,-1,0,1};
    
    int dx[4] = {-1,1,-1,1};
    int dy[4] = {-1,-1,1,1};
    
    int nx,ny;
    
    /* 상하좌우 1칸 검사 */
    for(int i=0; i<4; i++){
        nx = x + mx[i];
        ny = y + my[i];
        if(nx <0 || ny < 0 || nx > 4 || ny > 4){
            continue;
        }
        if(places[ny][nx] == 'P'){
            return false;
        }        
    }
    
    /* 상하좌우 2칸 검사 */
    for(int i=0; i<4; i++){
        nx = x + mx[i]*2;
        ny = y + my[i]*2;
        
        if(nx <0 || ny < 0 || nx > 4 || ny > 4){
            continue;
        }
        if(places[ny][nx] == 'P'){
            if(places[ny-my[i]][nx-mx[i]] != 'X'){  // 중간에 파티션이 없다면
                return false;
            }
        }   
    }
    
    /* 대각선 방향 검사 */
    for(int i=0; i<4; i++){
        nx = x + dx[i];
        ny = y + dy[i];
        
        if(nx <0 || ny < 0 || nx > 4 || ny > 4){
            continue;
        }
        if(places[ny][nx] == 'P'){
            if(places[ny][nx-dx[i]] != 'X' || places[ny-dy[i]][nx] != 'X'){
                return false;
            }
        }
    }
    
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    bool flag = true;
    for(int i=0; i<places.size(); i++){
        flag = true;
        for(int j=0; j<places[i].size(); j++){
            for(int k=0; k < places[i][j].size(); k++){        
                if(places[i][j][k] == 'P'){
                    if(!check(j,k, places[i])){
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag){
                answer.push_back(0);
                break;
            }
        }
        if(flag)
            answer.push_back(1);
    }
    
    return answer;
}
