#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100000

typedef struct {
	int data;
	int weight;
}queue;

int front = -1;
int rear = -1;

void push(queue* pqueue, queue q)
{
	pqueue[++rear].data = q.data;
	pqueue[rear].weight = q.weight;
}

queue pop(queue* pqueue)
{
	return pqueue[front++];
}

int main()
{
	int i, j, k, T, N, idx, target;
	int flag = 1;
	int cnt = 0;
	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		cnt = 0;
		scanf("%d %d", &N, &idx);
		queue* queue1 = (queue*)malloc(sizeof(queue)*MAX);
		for (j = 0; j < N; j++)
		{
			queue1[j].data = j + 1;
			scanf("%d", &queue1[j].weight);
		}
		target = queue1[idx].data;
		front = 0;
		rear = N - 1;
		while (1)
		{
			int maxweight = queue1[front].weight;
			for (k = front; k < rear + 1; k++)
			{
				if (maxweight < queue1[k + 1].weight)
				{
					flag = 0;
					push(queue1, pop(queue1));
					break;
				}
				else flag = 1;
			}

			if (flag == 1)
			{
				if (target == pop(queue1).data)
				{
					cnt++;
					break;
				}
				else cnt++;
			}
		}
		printf("%d\n", cnt);

	}

	return 0;
}


