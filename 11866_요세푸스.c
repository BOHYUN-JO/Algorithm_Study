#include <stdio.h>

typedef struct{
	int key;
}element;

element queue[1000];

int size =0;

int pop(int idx)
{
	size--;
	return queue[idx].key;	
}

void reset(int idx)
{
	int i;
	for(i=idx; i<size; i++)
	{
		queue[i].key = queue[i+1].key;
	}
}

int main()
{
	int N,K,i;
	int idx =0;
	scanf("%d %d", &N, &K);
	size = N;
	printf("<");
	for(i=0; i< size; i++)
	{
		queue[i].key = i+1;
	}
	while(1)
	{
		idx = (idx + K)%size -1;
		if(idx<0)
			idx = idx+size;
		if(size ==1)
			break;
		printf("%d, ", pop(idx));
		reset(idx);
	}
	printf("%d>", pop(idx));
	return 0;
}
