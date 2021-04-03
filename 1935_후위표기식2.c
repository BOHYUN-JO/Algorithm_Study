#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#define MAX 101

typedef struct _node
{
	double data;
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

void push(stack* pstack, double p)
{
	Node* newnode = (Node*)malloc(sizeof(Node));
	newnode->data = p;
	newnode->next = pstack->top;
	pstack->top = newnode;
}

double pop(stack* pstack)
{
	double temp;
	Node* tempnode;

	if (pstack->top == NULL)
		return;
	temp = pstack->top->data;
	tempnode = pstack->top;
	pstack->top = pstack->top->next;
	free(tempnode);

	return temp;
}
double eval(stack* pstack, char* str, int len)
{
	char tok;
	double op1, op2;
	for (int i = 0; i < len; i++)
	{
		tok = str[i];
		if (isdigit(tok))
			push(pstack, tok - '0');
		else
		{
			op2 = pop(pstack);
			op1 = pop(pstack);
			switch(tok)
			{
				case '+':
					push(pstack, op1 + op2);
					break;
				case '-':
					push(pstack, op1 - op2);
					break;
				case '*':
					push(pstack, op1*op2);
					break;
				case '/':
					push(pstack, op1 / op2);
					break;
			}
		}
	}
	return pop(pstack);
}

int main()
{
	int i,N,len;
	int j = 0;
	char temp;
	char str[MAX];
	stack stack1;
	init(&stack1);
	scanf("%d", &N);
	getchar();
	gets(str);
	len = strlen(str);
	for (i = 0; i < N; i++)
	{
		
		scanf("%c", &temp);
		for(j=0; j<len; j++)
		{
			char ch;
			if (str[j] >= 'A' && str[j] <= 'Z')
			{
				ch = str[j];
				str[j] = temp;
				for (int k = j + 1; k < len; k++)
				{
					if (str[k] == ch)
						str[k] = temp;
				}
				break;
			}
		}
		getchar();
	}
	double ret = eval(&stack1, str, len);
	printf("%.2f", ret);
	return 0;
}