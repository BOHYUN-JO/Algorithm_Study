#include <string>
#include <vector>

using namespace std;

int N, count;
int chess[13];

bool promising(int line)
{
    for (int i = 0; i < line; i++)
    {
        if (chess[i] == chess[line] || abs(chess[line] - chess[i]) == line - i)
            return false;
    }
    return true;
}


void nQueen(int line)
{
    if (line == N - 1)
    {
        count++;
        return;
    }
    for (int i = 0; i < N; i++)
    {
        chess[line + 1] = i;
        if (promising(line + 1))
        {
            nQueen(line + 1);
        }
    }
}

int solution(int n) {
    int answer = 0;
    N = n;
    nQueen(-1);
    answer = count;
    return answer;
}
