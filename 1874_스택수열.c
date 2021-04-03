#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int Data;

typedef struct _arrayStack
{
	Data stackArr[100001];
	int topIndex;
}ArrayStack;

typedef ArrayStack stack;

void StackInit(stack* pstack);
int SIsEmpty(stack* pstack);
void SPush(stack* pstack, Data data);
Data SPop(stack* pstack);
Data SPeek(stack* pstack);


int main()
{
	int i=0,N, j, num;
	int flag = 1;
	int data = 0;
	char ary[200001];
	stack stk1;
	StackInit(&stk1);
	SPush(&stk1, 0);
	scanf("%d", &N);
	
	while(N--)
	{
		scanf("%d", &num);
		if (num)
		{
			if (num > SPeek(&stk1))
			{
				while (num != SPeek(&stk1))
				{
					SPush(&stk1, ++data);
					ary[i++] = '+';
				}
				SPop(&stk1);
				ary[i++] = '-';
			}
			else if (num == SPeek(&stk1))
			{
				SPop(&stk1);
				ary[i++] = '-';
			}
			else flag = 0;
			
		}

	}
	
	if (flag == 1)
	{
		for (j = 0; j < i; j++)
			printf("%c\n", ary[j]);
	}
	else printf("NO");

	return 0;
}

void StackInit(stack* pstack)
{
	pstack->topIndex = -1;
}
int SIsEmpty(stack* pstack)
{
	if ((pstack->topIndex) == -1) return 1;
	else return 0;
}
void SPush(stack* pstack, Data data)
{
	pstack->topIndex += 1;
	pstack->stackArr[pstack->topIndex] = data;
}
Data SPop(stack* pstack)
{
	int rIdx;

	if (SIsEmpty(pstack))
	{
		return -1;
	}

	rIdx = pstack->topIndex;
	pstack->topIndex -= 1;
	return pstack->stackArr[rIdx];
}
Data SPeek(stack* pstack)
{
	if (SIsEmpty(pstack))
		return -1;

	return pstack->stackArr[pstack->topIndex];
}


