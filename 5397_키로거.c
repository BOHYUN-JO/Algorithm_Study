#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000001

typedef struct _node
{
	char data;
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

void push(stack* pstack, char p)
{
	Node* newnode = (Node*)malloc(sizeof(Node));
	newnode->data = p;
	newnode->next = pstack->top;
	pstack->top = newnode;
}

char pop(stack* pstack)
{
	char temp;
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
	int T,i;
	char order;
	
	scanf("%d", &T);
	getchar();
	for (i = 0; i < T; i++)
	{
		stack stack1, stack2;
		init(&stack1);
		init(&stack2);
		stack* pstack1, pstack2;
		while (1)
		{
			order = getchar();
			if (order == '\n')
				break;
			if (order == '<')
			{
				if (stack1.top == NULL)
					continue;
				else
					push(&stack2, pop(&stack1));
			}
			else if (order == '>')
			{
				if (stack2.top == NULL)
					continue;
				else
					push(&stack1, pop(&stack2));
			}
			else if (order == '-')
				pop(&stack1);
			else
				push(&stack1, order);
		}
		for (; stack1.top ;)
		{
			push(&stack2, pop(&stack1));
		}
		for (; stack2.top;)
		{
			printf("%c", stack2.top->data);
			stack2.top = stack2.top->next;
		}
		printf("\n");
	}
	return 0;
}