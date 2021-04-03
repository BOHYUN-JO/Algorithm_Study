#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int Data;

typedef struct _arrayStack
{
	Data stackArr[10000];
	int topIndex;
}ArrayStack;

typedef ArrayStack stack;

void StackInit(stack* pstack);
int SIsEmpty(stack* pstack);
void SPush(stack* pstack, Data data);
Data SPop(stack* pstack);
Data SPeek(stack* pstack);
int Ssize(stack* pstack);

int main()
{
	int i,N;
	int data=0;
	char order[6];
	stack stk;
	StackInit(&stk);
	scanf("%d",&N);
	for(i=0; i<N; i++)
	{
		scanf("%s", order);
		if(!strncmp(order, "top",3))
			printf("%d\n",SPeek(&stk));
		else if(!strncmp(order, "size",4))
			printf("%d\n", Ssize(&stk));
		else if(!strncmp(order, "empty",5))
			printf("%d\n", SIsEmpty(&stk));
		else if(!strncmp(order, "pop",3))
			printf("%d\n", SPop(&stk));
		else 
		{
			scanf("%d", &data);
			SPush(&stk, data);
		}
	}
	return 0;
}

void StackInit(stack* pstack)
{
	pstack->topIndex = -1;
}
int SIsEmpty(stack* pstack)
{
	if((pstack->topIndex) == -1) return 1;
	else return 0;
}
void SPush(stack* pstack, Data data)
{
	pstack->topIndex +=1;
	pstack->stackArr[pstack->topIndex] = data;
}
Data SPop(stack* pstack)
{
	int rIdx;
	
	if(SIsEmpty(pstack))
	{
		return -1;
	}
	
	rIdx = pstack->topIndex;
	pstack->topIndex -=1;
	return pstack->stackArr[rIdx];
}
Data SPeek(stack* pstack)
{
	if(SIsEmpty(pstack))
		return -1;

	return pstack->stackArr[pstack->topIndex];
}

int Ssize(stack* pstack)
{
	return (pstack->topIndex)+1;
}
