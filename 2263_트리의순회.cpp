#include <iostream>
#include <vector>

using namespace std;

int index[100001];
int inorder[100001];
int postorder[100001];

void dnc(int inStart, int inEnd, int postStart, int postEnd){
	if(inStart> inEnd || postStart > postEnd){
		return;
	}
	
	int rootIdx = index[postorder[postEnd]];
	int leftSize = rootIdx - inStart;
	int rightSize = inEnd - rootIdx;
	
	cout << inorder[rootIdx] << ' ';
	
	dnc(inStart, rootIdx-1, postStart, postStart+leftSize -1);
	dnc(rootIdx+1, inEnd, postStart+leftSize, postEnd-1);
}

int main(){
	int n, i, j, inLen, postLen;
	cin >> n;
	
	for(i=1; i<=n; i++){
		cin >> inorder[i];
		index[inorder[i]] = i;
	}
	
	for(i=1; i<=n; i++){
		cin >> postorder[i];
	}
	
	dnc(1, n, 1, n);
	
	return 0;
}
