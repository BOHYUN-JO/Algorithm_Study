#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    vector<int> answer;
    unordered_map<string, string> tree;
    unordered_map<string, int> money;
    int fee = 0;
    int enrollSize = enroll.size();
    int sellerSize = seller.size();
    string temp = "";
    
    for(int i=0; i< enrollSize; i++){
        if(referral[i] == "-"){
            tree[enroll[i]] = "Center";
        }else{
            tree[enroll[i]] = referral[i];
        }
        money[enroll[i]] = 0;
    }
    
    for(int i=0; i< sellerSize; i++){
        fee = amount[i] * 100;
        temp = seller[i];
        money[temp] += fee;
        while(true){
            fee /= 10;
            money[temp] -= fee;
            temp = tree[temp];
            if(fee == 0){
                break;
            }
            money[temp] += fee;
        }
    }
    
    for(int i=0; i<enroll.size(); i++){
        answer.push_back(money[enroll[i]]);
    }
    
    return answer;
}
