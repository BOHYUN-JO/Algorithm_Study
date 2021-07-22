#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool check(vector<int> v, int k, int m){
    int len = v.size();
    int skip = 0;
 
    for(int i=0 ; i<len; i++){
        if(v[i]-m <= 0) skip++;
        else skip = 0;
        
        if(skip >= k) return true;
    }
    
    return false;
}

int solution(vector<int> stones, int k) {
    int answer = 0;
    int ch = 0;
    int len = stones.size();
    int low, mid, high;
    low = *min_element(stones.begin(), stones.end());
    high = *max_element(stones.begin(), stones.end());
    while(low <= high){
        mid = low + ((high-low))/2;
        if(check(stones, k, mid)){
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
    answer = low;
    
    return answer;
}
