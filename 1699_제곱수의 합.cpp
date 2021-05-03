#include <cstdio>
#include <cmath>

using namespace std;

short int d[100001];


int dp(int n, int j) {
	n = n - (j * j);
	return (1 + d[n]);
}

int main() {
	int i, j, n, temp, mini = 100000, tmp;
	scanf("%d", &n);
	d[0] = 0;
	d[1] = 1;
	d[2] = 2;
	d[3] = 3;


	for (i = 4; i < 100001; i++) {
		temp = sqrt(i);
		for (j = temp; j > 0; j--) {
			tmp = dp(i, j);
			mini = mini < tmp ? mini : tmp;
			d[i] = mini;
		}
		mini = 1000000;
	}



	printf("%d", d[n]);

	return 0;
}
