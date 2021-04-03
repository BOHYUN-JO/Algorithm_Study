#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SWAP(x,y,t) ((t)=(x), (x)= (y), (y)=(t))

void sort(int* list, int n)
{
	int i, j, min, temp;
	for (i = 0; i < n - 1; i++)
	{
		min = i;
		for (j = i + 1; j < n; j++)
		{
			if (list[j] < list[min])
				min = j;
		}
		SWAP(list[i], list[min], temp);
	}
}

int main()
{
	int num,i;
	int* arr;
	scanf("%d", &num);
	arr = (int*)malloc(sizeof(int) * num);
	for (i = 0; i < num; i++)
		scanf("%d", &arr[i]);
	sort(arr, num);
	for (i = 0; i < num ;i++)
		printf("%d\n", arr[i]);
	printf("\n"); 
	free(arr);
	return 0;
}
