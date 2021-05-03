#include <cstdio>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;

int main(){
	int a,b,c, na,nb,nc, cura,curb,curc;
	int check[202][202] = {0,};
	int ans[202]={0,};
	tuple<int,int,int> t;
	queue<tuple<int,int,int> > q;
	int bottle[3];
	scanf("%d %d %d", &a, &b, &c);
	q.push(make_tuple(0,0,c));
	
	while(!q.empty()){
		cura = get<0>(q.front());
		curb = get<1>(q.front());
		curc = get<2>(q.front());
		q.pop();
		
		if(check[cura][curb]){
			continue;
		}
		
		check[cura][curb] = 1;
		
		if(cura == 0){
			ans[curc] = 1;
		}
		
		if(cura + curb > b){
			q.push(make_tuple(cura+curb-b, b, curc));
		}else{
			q.push(make_tuple(0, cura+curb, curc));
		}
		
		if(cura+curc > c){
			q.push(make_tuple(cura+curb-c, curb, c));
		}else{
			q.push(make_tuple(0, curb, cura+curc));
		}
		
		if(curb+cura > a){
			q.push(make_tuple(a, curb+cura-a, curc));
		}else{
			q.push(make_tuple(curb+cura, 0, curc));
		}
		
		if(curb+curc > c){
			q.push(make_tuple(cura, curb+curc-c, c));
		}else{
			q.push(make_tuple(cura, 0, curb+curc));
		}
			
		if(curc+cura > a){
			q.push(make_tuple(a, curb, curc+cura-a));
		}else{
			q.push(make_tuple(curc+cura, curb, 0));
		}
		
		if(curc+curb > b){
			q.push(make_tuple(cura, b, curc+curb-b));
		}else{
			q.push(make_tuple(cura, curc+curb, 0));
		}		
	}
	
	for(int i=0; i<=c ; i++){
		if(ans[i]){
			printf("%d ", i);
		}
	}
	
	return 0;
	
}
