#include <cstdio>
#include <queue>

using namespace std;
bool check[200001] = { false, };


int bfs(int n, int k) {
	int a,b,c,size, cur, cnt = 0;
	queue<int> q;
	q.push(n);
	check[n] = 1;
	while (1) {
		size = q.size();
		for (int i = 0; i < size; i++) {
			cur = q.front();
			q.pop();
			if (cur == k) {
				return cnt;
			}
			a = cur - 1;
			b = cur + 1;
			c = cur * 2;
			if (check[c] == false && k + 1 >= c) {
				q.push(c);
				check[c] = true;
			}
			if (check[a] == false && a >= 0) {
				q.push(a);

				check[a] = true;

			}
			if (check[b] == false && b <= 100000 && b <= k + 1) {
				q.push(b);

				check[b] = true;
			}

		}
		cnt++;
	}
}

int main() {
	int n, k;
	
	scanf("%d %d", &n, &k);

	printf("%d", bfs(n,k));

	return 0;
}
