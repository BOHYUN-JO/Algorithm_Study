#include <string>
#include <vector>

using namespace std;

int ans[2]={0,};

void zip(int y, int x, int len, vector<vector<int>>& arr){
    int half = len/2;
    int num = arr[y][x];
    bool flag = true;
    
    for(int i=y; i<y+len; i++){
        for(int j=x; j<x+len; j++){
            if(num != arr[i][j]){
                flag = false;
                break;
            }
        }
    }
    if(flag){
        ans[num]++;
        return;
    }else{
        zip(y,x,half,arr);
        zip(y,x+half,half,arr);
        zip(y+half,x,half,arr);
        zip(y+half,x+half,half,arr);
    }
    
}

vector<int> solution(vector<vector<int>> arr) {
    vector<int> answer;
    zip(0,0,arr.size(), arr);
    
    answer.push_back(ans[0]);
    answer.push_back(ans[1]);
    
    return answer;
}
