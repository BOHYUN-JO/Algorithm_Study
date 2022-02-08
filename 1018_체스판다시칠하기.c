#include <stdio.h>


//good
int main()
{
	int i,j,N, M, a,b,min =64;
	int cntB = 0, cntW = 0;
	scanf("%d %d", &N, &M);
	char chess[50][50];
	for (i = 0; i < N; i++)
		scanf("%s", &chess[i]);
	for (i = 0; i < N-7; i++)
	{
		for (j = 0; j < M-7; j++)
		{
			for (a = i; a < i + 8; a++)
			{
				for (b = j; b < j + 8; b++)
				{
					if ((a + b) % 2 == 0)
					{
						if (chess[a][b] == 'B')
							cntW++;
						else
							cntB++;
					}
					else
					{
						if (chess[a][b] == 'B')
							cntB++;
						else
							cntW++;
					}
				}
			}
			min = min < cntB ? min : cntB;
			min = min < cntW ? min : cntW;
		}
	}
	printf("%d\n", min);



	return 0;
}
