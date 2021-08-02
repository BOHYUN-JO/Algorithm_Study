#include <string>
#include <vector>
#include <set>

using namespace std;

bool check(vector<int> v, int now){
    for(int i=0; i < v.size(); i++){
        if( (v[i] & now) == v[i]){
            return false;
        }
    }
    return true;
}

int solution(vector<vector<string>> relation) {
    int answer = 0;
    vector<int> ans;
    int rowSize = relation.size();
    int colSize = relation[0].size();
    
    for(int i=1; i < (1<<colSize); i++){
        set<string> s;
        for(int j= 0; j <rowSize; j++){
            string now = "";
            for(int k=0; k< colSize; k++){
                if(i & (1<<k)){
                    now += relation[j][k];
                }
            }
            s.insert(now);
        }
        
        if(s.size() == rowSize && check(ans, i)){
            ans.push_back(i);
        }
    }
    
    answer = ans.size();
    
    return answer;
}
