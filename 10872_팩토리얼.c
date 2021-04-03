#include <stdio.h>
int Fibo(int num)
{
	if(num==0)
		return 0;
	else if(num==1)
		return 1;
	else
		return Fibo(num-1)+Fibo(num-2);
}
int main()
{
	int n;
	scanf("%d", &n);
	n = Fibo(n);
	printf("%d", n);
	
	return 0;	
}


