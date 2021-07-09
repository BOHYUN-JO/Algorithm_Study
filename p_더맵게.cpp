#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int> > pq;
    for(int i=0; i< scoville.size(); i++){
        pq.push(scoville[i]);
    }
    
    while(!pq.empty() && pq.top() < K ){
        int temp = pq.top();
        pq.pop();
        temp = temp + pq.top()*2;
        pq.pop();
         if(pq.size() == 1){
             if(temp >= K){
                 return ++answer;
             }
            return -1;
        }
        pq.push(temp);
        answer++;
    }
    return answer;
    
}
