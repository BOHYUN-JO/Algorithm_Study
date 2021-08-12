#include <string>
#include <vector>

using namespace std;

void hanoi(int from, int mid, int to, int n, vector<vector<int>>& answer){
    if(n == 1){
        answer.push_back({from,to});
    }else{
         hanoi(from, to, mid, n-1,answer);
         answer.push_back({from,to});
         hanoi(mid, from, to, n-1,answer);
    }
   
}

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer;
    hanoi(1,2,3,n,answer);
    
    return answer;
}
