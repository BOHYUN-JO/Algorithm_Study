#include <bits/stdc++.h>

using namespace std;

int main(){
	int size;
	int n,m,cnt =0, tA=0, tB=0;
	map<int,int> sumA;
	map<int, int> sumB;
	int pizzaA[1000];
	int pizzaB[1000];
	
	cin >> size;
	cin >> m >> n;
	
	for(int i=0; i<m; i++){
		cin >> pizzaA[i];
		tA += pizzaA[i];
	}
	for(int i=0; i<n; i++){
		cin >> pizzaB[i];
		tB += pizzaB[i];
	}
	
	// pizza A 누적합 계산 및 count 
	for(int i=0; i<m; i++){
		int it = m, j=i, sum=0; 
		while(it--){
			sum += pizzaA[j];
			if(sum == size){	// count
				cnt++; 
			}
			if(sumA.find(sum) != sumA.end()){
				sumA[sum] +=1;
			}else{
				sumA[sum] = 1;
			}
			j = (j+1 >= m) ? 0 : j+1;
		}
	}
	
	// pizza B 누적합 계산 및 count 
	for(int i=0; i<n; i++){
		int it = n, j=i, sum=0; 
		while(it--){
			sum += pizzaB[j];
			if(sum == size){	// count
				cnt++; 
			}
			
			if(sumB.find(sum) != sumB.end()){
				sumB[sum] += 1;
			}else{
				sumB[sum] = 1;
			}
		
			j = (j+1 >= n) ? 0 : j+1;
		}
	}
	
	// 중복제거
	sumA[tA] = 1;
	sumB[tB] = 1;
	
	cnt = sumA[size] + sumB[size];
	
	for(auto& it : sumA){
		int target = size - it.first;
		if(sumB.find(target) != sumB.end() ){
			cnt += it.second * sumB[target];
		}
	}
	
	cout << cnt;
	
	return 0;
}
