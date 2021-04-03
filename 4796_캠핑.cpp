#include <iostream>
#include <vector>

using namespace std;

int main(){
	int L, P, V, caseCount =0, cnt =0;
	while(1){
		cnt = 0;
		cin >> L >> P >> V;
		caseCount++;
		if(L == 0 && P == 0 && V == 0){
			break;
		}
		while(V){
			if(V >= P){
				cnt+=L;
				V-=P;
			}else{
				if(P> V && V>=L){
					cnt += L;
					V = 0;
				}else{
					cnt+= V;
					V = 0;
				}
				
			}
		}
		cout << "Case " << caseCount << ": " << cnt << endl;				
	}
}
