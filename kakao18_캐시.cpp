#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <boost/algorithm/string.hpp>

using namespace std;

map<string, int> m;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    int cnt = 0;
    int min = 0x3f;
    
    for(int i=0; i< cities.size(); i++){
        boost::algorithm::to_lower(cities[i]);
    }
    
    for (int i = 0; i < cities.size(); i++) {
        if (m.find(cities[i]) != m.end()) {   // hit
            answer += 1;
            m[cities[i]] = cnt++;
        }
        else {  // miss
            if (cacheSize != 0 && m.size() != 0 && m.size() >= cacheSize) {
                map<string, int>::iterator it = m.end();
                min = 987654321;
                for (map<string, int>::iterator it2 = m.begin(); it2 != m.end(); it2++) {
                    if (it2->second < min) {
                        min = it2->second;
                        it = it2;
                    }
                }
                if(it != m.end()){
                    m.erase(it);
                }
        
                m[cities[i]] = cnt++;
            }
            else if (cacheSize == 0) {
                //nothing to do
            }
            else {
                m[cities[i]] = cnt++;
            }
            answer += 5;
        }
    }

    return answer;
}
