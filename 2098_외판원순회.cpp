#include <cstdio>
#include <string>

#define INF 987654321

using namespace std;

int n, endBit;
int dist[16][16];
int cost[16][1 << 16];

int min(int a, int b) {
	return a < b ? a : b;
}

int dfs(int curNode, int curBit) {

	if (curBit == endBit) {	// ��� ���ø� �湮���� ���
		if (dist[curNode][0] == 0) {	// �ڱ� �ڽ�(0���� 0)
			return INF;
		}
		else {	// 0 �̿��� ���ÿ��� 0
			return dist[curNode][0];
		}
	}

	if (cost[curNode][curBit] != -1) {	// ���� �ּҰŸ��� ���� ���
		return cost[curNode][curBit];
	}
	cost[curNode][curBit] = INF;

	for (int i = 0; i < n; i++) {
		if (dist[curNode][i] == 0) {	// �ڱ� �ڽ�
			continue;
		}
		if ((curBit & (1 << i) )== (1 << i))	// �̹� �湮�� ����
			continue;

		cost[curNode][curBit] = min(cost[curNode][curBit], dist[curNode][i] + dfs(i, curBit | 1 << i));

	}

	return cost[curNode][curBit];

}

int main() {
	scanf("%d", &n);
	endBit = (1 << n) - 1; 

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &dist[i][j]);
		}
	}

	memset(cost, -1, sizeof(cost));

	printf("%d", dfs(0, 1));

	return 0;
}