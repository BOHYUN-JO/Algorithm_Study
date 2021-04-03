#include <stdio.h>

int main()
{
	int arr[5];
	int bur, drink;
	for(int i = 0; i<5; i++)
	{
		scanf("%d", &arr[i]);
	}
	bur = arr[0] > arr[1] ? arr[1] : arr[0];
	bur = bur > arr[2] ? arr[2] : bur;
	drink = arr[3] > arr[4] ? arr[4] : arr[3];
	printf("%d", bur+drink-50);
	return 0;
}
