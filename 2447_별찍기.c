#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char mat[2201][2201];

void solve(int y, int x, int num)
{
	if(num==1)
	{
		mat[y][x] = '*';
		return;
	}
	int div = num/3;
	for(int i =0; i<3; i++)
	{
		for(int j=0; j<3; j++)
		{
			if(i==1 && j ==1);
			else
				solve(y+(i*div), x+(j*div), div);
		}
	}
}
int main()
{
	int N,i;
	
	scanf("%d", &N);
	memset(mat,' ', sizeof(mat));
	solve(0,0,N);
	for(int i =0; i <N; i++)
	{
		for(int j =0 ; j<N;j++)
			printf("%c", mat[i][j]);
		printf("\n");
	}
	return 0;
}
