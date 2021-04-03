#include <stdio.h>

int main()
{
	int n,i,j,cnt;
	int x[201];
	int y[201];

	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%d %d", &x[i], &y[i]);
	}
	for (i = 0; i < n; i++)
	{
		cnt = 0;
		for (j = 0; j < n; j++)
		{
			if (i == j)
				continue;
			else if (x[i] < x[j] && y[i] < y[j])
			{
				cnt++;
			}
			else
				continue;
		}
		printf("%d ", cnt + 1);
	}
	return 0;
}