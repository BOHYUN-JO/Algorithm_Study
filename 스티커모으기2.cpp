#include <iostream>
#include <vector>

using namespace std;

int solution(vector<int> sticker)
{
    int answer =0;
    int dp1[100001];
    int dp2[100001];
    
    if(sticker.size() ==1){
        return sticker[0];
    }else if(sticker.size() == 2){
        return max(sticker[0], sticker[1]);
    }
    
    dp1[0] = sticker[0];
    dp1[1] = dp1[0];
    
    for(int i=2; i<sticker.size()-1;i++){
        dp1[i] = max(dp1[i-1], dp1[i-2] +sticker[i]);
    }
    
    dp2[0] = 0;
    dp2[1] = sticker[1];
    dp2[2] = dp2[1];
    
    for(int i=2; i<sticker.size(); i++){
        dp2[i] = max(dp2[i-1], dp2[i-2] + sticker[i]);
    }
    
    answer = max(dp1[sticker.size()-2], dp2[sticker.size()-1]);
    
    return answer;
}
