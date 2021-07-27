#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int dp[1000001];

bool check(int comp, int idx, int min){
    bool left = false;
    bool right = false;
    
    if(min < comp){
        left = true;
    }
    
    if(dp[idx] < comp){
        right = true;
    }
    
    if(left && right){
        return false;
    }else return true;

}

int solution(vector<int> a) {
    int answer = 0;
    int len = a.size();
    int min = 1000000001;
    
    for(int i=len-1; i>=1; i--){
        if(min > a[i]){
            min = a[i];
        }
        dp[i] = min;
    }
    
    min = 1000000001;
    for(int i=0; i<len ; i++){
        int comp = a[i];
        if(min > comp){
            min = comp;
        }
        if(check(comp,i, min)){
            answer++;
        }
    }
    
    return answer;
}
