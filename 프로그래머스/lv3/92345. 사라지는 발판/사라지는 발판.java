import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int r,c;
    static class Result{
        boolean win;
        int cnt;
        Result(boolean win, int cnt){
            this.win = win;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        r = board.length;
        c = board[0].length;
        
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0,0).cnt;
    }
    
    public static boolean canMove(int[][] board, int x, int y){
        if(x<0 || y<0 || x>=r || y>=c || board[x][y] == 0) return false;
        return true;
    }
    
    public static Result dfs(int[][] board, int ax, int ay,int bx, int by, int adepth, int bdepth){
        boolean win = false;
        int winCnt = 5*5;
        int loseCnt = adepth + bdepth;
        
        if(adepth == bdepth && board[ax][ay] == 1){
            for(int i=0; i<4; i++){
                int anx = ax + dx[i];
                int any = ay + dy[i];
                if(!canMove(board, anx, any)) continue;
                board[ax][ay] = 0;
                Result r = dfs(board, anx, any, bx, by, adepth+1, bdepth);
                board[ax][ay] = 1;
                win |= !r.win;
                if(r.win){
                    loseCnt = Math.max(loseCnt, r.cnt);
                }else{
                    winCnt = Math.min(winCnt, r.cnt);
                }
            }
            
        }else if(adepth > bdepth && board[bx][by] == 1 ){
            for(int i=0; i<4; i++){
                int bnx = bx + dx[i];
                int bny = by + dy[i];
                if(!canMove(board, bnx, bny)) continue;
                board[bx][by] = 0;
                Result r = dfs(board, ax, ay, bnx, bny, adepth, bdepth+1);
                board[bx][by] = 1;
                win |= !r.win;
                if(r.win){
                    loseCnt = Math.max(loseCnt, r.cnt);
                }else{
                    winCnt = Math.min(winCnt, r.cnt);
                }
            }
        }
        
        return new Result(win, win ? winCnt : loseCnt );        
        
    }
}