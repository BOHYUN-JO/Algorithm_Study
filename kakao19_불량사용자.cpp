#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<vector<string>> combination(vector<string> user_id, vector<string> banned_id) {
    vector<int> ind;
    vector<string> inner;
    vector<vector<string>> combi;

    for (int i = 0; i < banned_id.size(); i++) {
        ind.push_back(1);
    }

    for (int i = 0; i < user_id.size() - banned_id.size(); i++) {
        ind.push_back(0);
    }

    sort(ind.begin(), ind.end());

    do {
        inner.clear();
        for (int i = 0; i < ind.size(); i++) {
            if (ind[i] == 1) {
                inner.push_back(user_id[i]);
            }
        }
        combi.push_back(inner);
    } while (next_permutation(ind.begin(), ind.end()));

    return combi;

}

bool check(string str1, string str2) {
    if (str1.length() != str2.length()) {
        return false;
    }

    for (int i = 0; i < str1.length(); i++) {
        if (str2[i] == '*') {
            continue;
        }
        else if (str1[i] == str2[i]) {
            continue;
        }
        else {
            return false;
        }
    }

    return true;
}

int count(vector<vector<string>> combi, vector<string> banned_id) {
    int cnt = 0;

    for (int i = 0; i < combi.size(); i++) {
        int flag = false;
        vector<string> temp;
        sort(combi[i].begin(), combi[i].end());
        do {
            temp = combi[i];
            for (int j = 0; j < banned_id.size(); j++) {
                for (int k = 0; k < temp.size(); k++) {
                    if (check(temp[k], banned_id[j])) {
                        temp[k] = "";
                        break;
                    }
                }
            }
            for (int j = 0; j < temp.size(); j++) {
                if (temp[j] == "") {
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
                break;
            }
        } while (next_permutation(combi[i].begin(), combi[i].end()));
        
    }

    return cnt;
}

int solution(vector<string> user_id, vector<string> banned_id) {
    int answer = 0;
    vector<vector<string> > combi = combination(user_id, banned_id);

    answer = count(combi, banned_id);


    return answer;
}

int main() {
    vector<string> user_id;
    vector<string> banned_id;
    user_id.push_back("frodo");
    user_id.push_back("fradi");
    user_id.push_back("crodo");
    user_id.push_back("abc123");
    user_id.push_back("frodoc");
    banned_id.push_back("fr*d*");
    banned_id.push_back("*rodo");
    banned_id.push_back("******");
    banned_id.push_back("******");
    cout << solution(user_id, banned_id);

}