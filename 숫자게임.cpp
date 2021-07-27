#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    int j = 0;
    int Asize = A.size();
    int Bsize = B.size();
    
    sort(A.begin(), A.end(), greater<>());
    sort(B.begin(), B.end(), greater<>());
    
    for(int i=0; i<Asize; i++){
        if(A[i] < B[j]){
            j++;
            answer++;
        }
    }
    
    return answer;
}
