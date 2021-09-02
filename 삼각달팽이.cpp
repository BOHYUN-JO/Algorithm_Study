#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    int arr[1001][1001];
    int size = (n*(n+1))/2;
    int num = 1;
    int line = n;
    int i=-1,j=0,mode =0;
    
    fill(arr[0], arr[1001], 0);
    
    while(num <= size){
        for(int k=0; k<line; k++){
            switch(mode){
                case 0: // 아래로 이동
                    arr[++i][j] = num++;
                    break;
                case 1: // 오른쪽 이동
                    arr[i][++j] = num++;
                    break;
                case 2: // 위로 이동
                    arr[--i][--j] = num++;
            }
        }
        line--;
        mode = (mode+1)%3;
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            answer.push_back(arr[i][j]);
        }
    }
    
    return answer;
}
