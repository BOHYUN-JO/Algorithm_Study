#include <bits/stdc++.h>

using namespace std;

deque<int> gear[4];

void rotateLeft(int num){	// 반시계 
	int tmp = gear[num].front();
	gear[num].pop_front();
	gear[num].push_back(tmp);
}

void rotateRight(int num){	// 시계 
	int tmp = gear[num].back();
	gear[num].pop_back();
	gear[num].push_front(tmp);
}


int main(){
	
	int k;
		
	for(int i=0; i<4; i++){
		string tmp = "";
		cin >> tmp;
		for(int j=0; j<tmp.length(); j++){
			gear[i].push_back(tmp[j]-'0');
		}
	} 
	cin >> k;
	int a,b,tmp;
	for(int i=0; i<k; i++){
		cin >> a >> b;
		if(b == -1){
			if(a==1){
				if(gear[0][2] != gear[1][6]){
					if(gear[1][2] != gear[2][6]){
						if(gear[2][2] != gear[3][6]){
							rotateRight(3);
						}
						rotateLeft(2);
					}
					rotateRight(1);
				}
			}else if(a==2){
				if(gear[1][6] != gear[0][2]){
					rotateRight(0);
				}
				
				if(gear[1][2] != gear[2][6]){
					if(gear[2][2] != gear[3][6]){
						rotateLeft(3);
					}
					rotateRight(2);
				}
			}else if(a==3){
				if(gear[2][2] != gear[3][6]){
					rotateRight(3);
				}
				
				if(gear[2][6] != gear[1][2]){
					if(gear[1][6] != gear[0][2]){
						rotateLeft(0);
					}
					rotateRight(1);
				}
			}else{
				if(gear[3][6] != gear[2][2]){
					if(gear[2][6] != gear[1][2]){
						if(gear[1][6] != gear[0][2]){
							rotateRight(0);
						}
						rotateLeft(1);
					}
					rotateRight(2);
				}
			}
			rotateLeft(a-1);
		}else{
			if(a==1){
				if(gear[0][2] != gear[1][6]){
					if(gear[1][2] != gear[2][6]){
						if(gear[2][2] != gear[3][6]){
							rotateLeft(3);
						}
						rotateRight(2);
					}
					rotateLeft(1);
				}
			}else if(a==2){
				if(gear[1][6] != gear[0][2]){
					rotateLeft(0);
				}
				
				if(gear[1][2] != gear[2][6]){
					if(gear[2][2] != gear[3][6]){
						rotateRight(3);
					}
					rotateLeft(2);
				}
			}else if(a==3){
				if(gear[2][2] != gear[3][6]){
					rotateLeft(3);
				}
				
				if(gear[2][6] != gear[1][2]){
					if(gear[1][6] != gear[0][2]){
						rotateRight(0);
					}
					rotateLeft(1);
				}
			}else{
				if(gear[3][6] != gear[2][2]){
					if(gear[2][6] != gear[1][2]){
						if(gear[1][6] != gear[0][2]){
							rotateLeft(0);
						}
						rotateRight(1);
					}
					rotateLeft(2);
				}
			}
			rotateRight(a-1);
		}
		
	}

	
	int sum = 0;
	
	if(gear[0][0] == 1) sum +=1;
	if(gear[1][0] == 1) sum +=2;
	if(gear[2][0] == 1) sum +=4;
	if(gear[3][0] == 1) sum += 8;
	
	cout << sum << endl;
	
		
	return 0;
}
