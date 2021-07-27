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
    
    /* ���� Ÿ�� ���� ���ϱ� */
    for (int i = 0; i < gems.size(); i++)
        type.insert(gems[i]);
    
    while (true) {
        /* end ������ ����, ������ ��� ������ �ϳ� �̻� �����ϴ� ������ */
        for (i = end; i < gems.size(); i++) {
            count[gems[i]]++;
            if (count.size() == type.size()) {
                end = i;
                break;
            }
        }
        
        /* end�� ������ �Ѿ�� ���� */
        if (i == gems.size())
            break;
        
        /* start ������ ����, �� ������ �����ϸ� ��� ������ ������ �� ���� �� ���� */
        for (i = start; i < gems.size(); ++i) {
            if (count[gems[i]] == 1) {
                start = i;
                break;
            }
            else count[gems[i]]--;
        }
        
        /* ���� �ϼ��� ������ ���̰� minLen ���� ������ ������Ʈ */
        if (end - start < minLen) {
            answer[0] = start + 1;
            answer[1] = end + 1;
            minLen = end - start;
        }
        
        /* ���ο� ���� �ݺ� */
        count.erase(gems[start]);   // start ���� ����
        start++;
        end++;
      
    }
            
    return answer;
}
