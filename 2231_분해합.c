#include <stdio.h>

int main()
{
	int m,i,j,k;
	int n=0;
	int sum = 0;
	scanf("%d", &m);
	for(i=1; i<m; i++)
	{
		j = i;
		sum = 0;
		while(j>0)
		{
			k = j%10;
			j = j/10;
			sum += k;
		}
		sum += i;
		if(sum == m)
		{
			n= i;
			break;
		}
	} 
	printf("%d", n);
	return 0;
}
