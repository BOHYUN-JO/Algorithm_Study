#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>
#include <tuple>

using namespace std;

int solution(vector<vector<int>> board) {
    int mx[4] = { 1,0,-1,0 };
    int my[4] = { 0,1,0,-1};
    int dir[4] = {0,1,2,3};
    int cur_dir;
    int cost=0;
    int answer = 987654321;
    int size = board[0].size();
    vector<vector<vector<int>>> dp;
    queue<tuple<int,int,int>> q;
    
    /* dp ∫§≈Õ √ ±‚»≠*/
    for(int k=0; k<4; k++){
        vector<vector<int>> tmp;
        for(int i=0; i<size; i++){
            vector<int> temp;
            for(int j=0; j<size; j++){
                temp.push_back(987654321);
            }
            tmp.push_back(temp);
        }
        dp.push_back(tmp);
    }
    
    for(int i=0; i<4; i++){
        dp[i][0][0] = 0;
    }
    
    /* BFS */
    if(board[0][1] == 0){
        dp[0][0][1] = 100;
    }
    if(board[1][0] == 0){
        dp[1][1][0] = 100;
    }
    q.push({0,0,0});    
    while(!q.empty()){
        int y = get<0>(q.front());
        int x = get<1>(q.front());
        int post_dir = get<2>(q.front());
        q.pop();
        for(int i=0; i<4; i++){
            int ny = y + my[i];
            int nx = x + mx[i];
            
            if(ny<0 || nx <0 || nx >= size || ny >= size || board[ny][nx] == 1)
                continue;
            
            cur_dir = i;
            
            if(x==0 && y==0 ){
                cost = 100;
            }else if(post_dir == cur_dir){
                cost = 100;
            }else cost = 600;
            
            if(dp[post_dir][y][x] + cost <= dp[i][ny][nx]){
                dp[i][ny][nx] = dp[post_dir][y][x] + cost;
                q.push(make_tuple(ny,nx,cur_dir));
            }
            
        }
        
    }
    
    for(int i=0; i<4; i++){
        if(answer > dp[i][size-1][size-1]){
            answer = dp[i][size-1][size-1];
        }
    }
    
      
    return answer;
}
