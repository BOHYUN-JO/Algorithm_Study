#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> gems) {
    vector<int> answer(2);
    set<string> type;    
    int minLen = 100001; 
    unordered_map<string, int> count; 
    int i;
    int start = 0;
    int end = 0;
    
    /* 보석 타입 전부 구하기 */
    for (int i = 0; i < gems.size(); i++)
        type.insert(gems[i]);
    
    while (true) {
        /* end 포인터 증가, 보석의 모든 종류를 하나 이상씩 포함하는 곳까지 */
        for (i = end; i < gems.size(); i++) {
            count[gems[i]]++;
            if (count.size() == type.size()) {
                end = i;
                break;
            }
        }
        
        /* end가 범위를 넘어가면 종료 */
        if (i == gems.size())
            break;
        
        /* start 포인터 증가, 이 보석을 제외하면 모든 종류를 포함할 수 없는 곳 까지 */
        for (i = start; i < gems.size(); ++i) {
            if (count[gems[i]] == 1) {
                start = i;
                break;
            }
            else count[gems[i]]--;
        }
        
        /* 현재 완성된 구간의 길이가 minLen 보다 작으면 업데이트 */
        if (end - start < minLen) {
            answer[0] = start + 1;
            answer[1] = end + 1;
            minLen = end - start;
        }
        
        /* 새로운 구간 반복 */
        count.erase(gems[start]);   // start 지점 제외
        start++;
        end++;
      
    }
            
    return answer;
}
