#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M, K, tmax = 0;
int cnt[10];
int block[10][5];

/* first solution
void Combination(vector<int>& arr, vector<int>& comb, int index, int depth)
{
    if (depth == comb.size())
    {
        fill(cnt, cnt + 10, M);
        for (int i = 0; i < comb.size(); i++) {
            if (cnt[comb[i]] > 0) {
                cnt[comb[i]]--;
            }
            else {
                return;
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (cnt[i] < M) {
                sum += block[i][cnt[i]];
            }
        }
        if (tmax < sum) {
            tmax = sum;
        }

        return;
    }
    else
    {
        for (int i = index; i < arr.size(); i++)
        {
            comb[depth] = arr[i];
            Combination(arr, comb, i, depth + 1);
        }
    }
}
*/

/* best solution */
void push(int r, int remainK, int sum) {
    if (remainK == 0 || r == N) {
        tmax = sum > tmax ? sum : tmax;
        return;
    }

    for (int pushL = 0; pushL <= M; pushL++) {
        if (remainK - pushL >= 0) {
            int removed = pushL == 0 ? 0 : block[r][M - pushL];
            push(r + 1, remainK - pushL, sum + removed);
        }
    }
}

int main() {
	
    vector<int> vec;
	
	cin >> N >> M >> K;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> block[i][j];
		}
	}

    for (int i = 0; i < N; i++) {
        vec.push_back(i);
    }
    vector<int> combi(K);

    push(0, K, 0);

	cout << tmax;

	return 0;
}
