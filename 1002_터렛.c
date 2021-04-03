#include <stdio.h>
#include <math.h>

int main()
{
	int t;
	double x1,x2,y1,y2,r1,r2;
	double dis;
	scanf("%d", &t);
	while(t--)
	{
		scanf("%lf %lf %lf %lf %lf %lf", &x1, &y1, &r1, &x2, &y2, &r2);
		dis= sqrt((double)(pow(x1-x2,2)+pow(y1-y2,2)));
		if(x1==x2 && y1 == y2)
		{
			if(r1==r2)	printf("-1\n");
			else printf("0\n");
		}
		else
		{
			if(dis>fabs(r1-r2)&& dis< r1+r2) printf("2\n");
			else if(dis == r1+r2 || dis == fabs(r1-r2)) printf("1\n");
			else printf("0\n");
		}	
	}
	return 0;
}
