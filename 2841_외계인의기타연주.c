#include <stdio.h>
#include <stdlib.h>

typedef struct _node
{
	int data;
	struct _node* next;
}Node;

typedef struct _stack
{
	Node* top;
}Stack;

typedef Stack stack;

void init(stack* pstack)
{
	pstack->top = NULL;
}

void push(stack* pstack, int p)
{
	Node* newnode = (Node*)malloc(sizeof(Node));
	newnode->data = p;
	newnode->next = pstack->top;
	pstack->top = newnode;
}

int pop(stack* pstack)
{
	int temp;
	Node* tempnode;

	if (pstack->top == NULL)
		return;
	temp = pstack->top->data;
	tempnode = pstack->top;
	pstack->top = pstack->top->next;
	free(tempnode);

	return temp;
}

int main()
{
	int N, P, i, jul, pret;
	int cnt = 0;
	int size = 1;
	scanf("%d %d", &N, &P);
	stack** ptr = (stack**)malloc(sizeof(stack*)*6);
	for (i = 0; i < 6; i++)
	{
		ptr[i] = (stack*)malloc(sizeof(stack));
		init(ptr[i]);
	}
	for (i = 0; i < N; i++)
	{
		scanf("%d %d", &jul, &pret);
		if (ptr[jul - 1]->top==NULL)
		{
			cnt++;
			push(ptr[jul - 1], pret);
		}
		else if (ptr[jul - 1]->top->data < pret)
		{
			cnt++;
			push(ptr[jul - 1], pret);
		}
		else if (ptr[jul - 1]->top->data == pret)
		{
			continue;
		}
		else
		{
			while (1)
			{
				if (ptr[jul - 1]->top == NULL)
					break;
				else if (ptr[jul - 1]->top->data < pret)
					break;
				else if (ptr[jul - 1]->top->data == pret)
				{
					cnt--;
					pop(ptr[jul - 1]);
				}
				else {
					cnt++;
					pop(ptr[jul - 1]);
				}
			}
			cnt++;
			push(ptr[jul - 1], pret);
		}
	}
	printf("%d", cnt);
	for (i = 0; i < 6; i++)
		free(ptr[i]);
	free(ptr);
	return 0;
}

