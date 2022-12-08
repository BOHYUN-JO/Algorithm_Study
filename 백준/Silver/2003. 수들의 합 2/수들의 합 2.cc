#include <iostream>
using namespace std;
 
int main(){
    int N, M, arr[10000];
    cin >> N >> M;
    for(int i=0; i<N; i++){
        cin >> arr[i];
    }
        
    int answer = 0, sum = 0, s = 0, e = 0;
    while(s<N){
        if(sum >= M){ 
            sum -= arr[s];
            s++;
        }else{
            sum += arr[e];
            e++;
        } 
        if(sum == M) answer++;
    }
    
    cout << answer;
}