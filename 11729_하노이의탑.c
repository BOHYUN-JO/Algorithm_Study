#include <stdio.h>
#include <math.h>

void hanoi(int n, int from, int by, int to)
{
	if(n==1)
	{
		printf("%d %d\n", from, to);
		return;
	}
	else
	{
		hanoi(n-1, from, to, by);
		printf("%d %d\n", from, to);
		hanoi(n-1, by,from,to);
	}
}
int main()
{
	int i;
	long long int n, cnt;
	int from, to;
	scanf("%lld", &n);
	cnt = pow(2.0, n);
	printf("%lld\n", cnt);
	if(n<=20)
		hanoi(n,1,2,3);
	else ;
	return 0;
}
