#include <iostream>

#define endl "\n"

using namespace std;

int arr[500001];
int tmp[500001];

long long dnc(int start, int end){
	if(start == end){
		return 0;
	}
	int mid = (end + start)/2;
	long long answer = dnc(start, mid) + dnc(mid+1, end);
	
	int i = start;
	int j = mid+1;
	int index = start;
	while(i<=mid || j<=end){
		if(i<=mid && (end < j || arr[i] <= arr[j] )){
			tmp[index++] = arr[i++];
		}else{
			tmp[index++] = arr[j++];
			answer += mid - i +1;
		}
	}
	for(int i= start; i<=end; i++){
		arr[i] = tmp[i];
	}
	
	return answer;
}

int main(){
	int n;
	long long ans;
	cin >> n;
	for(int i=0; i<n; i++){
		cin >> arr[i];
	} 
	ans = dnc(0, n-1);
	
	cout << ans << endl;
	
	return 0;
}
