#include <string>
#include <vector>
#include <iostream>
#include <cmath>

#define ll long long

using namespace std;

//sds
vector<ll> solution(vector<ll> numbers) {
    vector<ll> answer;
    for(int i=0; i<numbers.size(); i++){
        ll t = numbers[i];
        ll tmp = t;
        int cnt = 0;
        while(1){
            if((tmp%2) == 0){
                break;
            }
            tmp /=2;
            cnt++;
        }
        if(cnt != 0){
            ll temp = (ll)pow(2,cnt-1);
            t=t+(ll)pow(2,cnt)-temp;
        } else
            t+=1<<cnt;

        answer.push_back(t);
    }
    return answer;
}
