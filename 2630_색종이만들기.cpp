#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int blue = 0;
int white = 0;
int v[130][130];
void div(int xs, int ys, int xe, int ye) {

	int startColor = v[xs][ys];
	
	for (int i = xs; i < xe; i++) {
		for (int j = ys; j < ye; j++) {
			if (startColor == 0 && v[i][j] == 1) {
				startColor = 2;
			}
			else if (startColor == 1 && v[i][j] == 0) {
				startColor = 2;
			}
			if (startColor == 2) {
				div( xs, ys, (xs + xe) / 2, (ys + ye) / 2);
				div( (xs + xe) / 2, (ys + ye) / 2, xe, ye);
				div( xs, (ys + ye) / 2, (xs + xe) / 2, ye);
				div( (xs + xe) / 2, ys, xe, (ys + ye) / 2);
				return;
			}
		}
	}

	if (startColor == 0) white++;
	else if (startColor == 1) blue++;
	
	return;
}

int main() {
	int N;
	cin >> N;


	memset(v, 0, sizeof(v));
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> v[i][j];
		}
	}

	div(0, 0, N, N);
	cout << white << endl << blue << endl;
	
	return 0;
}