#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <iostream>

using namespace std;

// wow good dd
int solution(string word) {
    int answer = 0;
    vector<char> v;
    vector<int> ind(25,0);
    char arr[5] = {'A','E','I', 'O', 'U'};
    set<string> dict;
    
    ind[24] = 1;
    sort(ind.begin(), ind.end());
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            v.push_back(arr[i]);
        }
    }
    
    for(int i=0; i<5; i++){
        do{
           string temp = "";
           for(int j=0; j<ind.size(); j++){
               if(ind[j] == 1){
                   temp += v[j];                
               }
           }
           sort(temp.begin(), temp.end());
           do{
               dict.insert(temp);
           }while(next_permutation(temp.begin(), temp.end()));
        }while(next_permutation(ind.begin(), ind.end()));
        ind[0] = 1;
        sort(ind.begin(), ind.end());
    }
    
    for(auto it = dict.begin(); it!=dict.end(); it++){
        answer++;
        if(*it == word){
            break;
        }
    }
    
    return answer;
}
