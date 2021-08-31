#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long low, mid, high,sum=0;
    
    sort(times.begin(), times.end());
    high = (long long)times[times.size()-1]*(long long)n;
    low = (n*times[0])/times.size();
    
    while(low <high){
        mid = (high+low)/2;
        sum = 0;
        for(int i=0; i<times.size(); i++){
            sum += mid/times[i];
        }
        if(sum >= n){
            high = mid;
        }else{
            low = mid+1;
        }
        
    }
    
    return high;
}
