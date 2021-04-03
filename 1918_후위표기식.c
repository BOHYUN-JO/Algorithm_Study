#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 101

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
int getprec(char op)
{
	switch(op)
	{
		case '*':
		case '/':
			return 5;
		case '+':
		case '-':
			return 3;
		case '(':
			return 1;
	}

	return -1;
}
int WhoPrec(char op1, char op2)
{
	int op1prec = getprec(op1);
	int op2prec = getprec(op2);
	
	if (op1prec > op2prec)
		return 1;
	else if (op1prec == op2prec)
		return 0;
	else return -1;
}
void postfix(stack* pstack, char data)
{
	char temp;
	if ('A' <= data && data <= 'Z')
		printf("%c", data);
	else
	{
		switch (data)
		{
		case '(':
			push(pstack, data);
			break;
		case ')':
			while (1)
			{
				temp = pop(pstack);
				if (temp == '(')
					break;
				printf("%c", temp);
			}
			break;
		case '+': case '-':
		case '*': case '/':
			while (pstack->top != NULL && WhoPrec(pstack->top->data, data)>=0)
				printf("%c", pop(pstack));
			push(pstack, data);
			break;
		}
	}
}
int main()
{
	int i,len;
	stack stack1;
	init(&stack1);
	char str[MAX];
	gets(str);
	len = strlen(str);
	for (i = 0; i < len; i++)
	{
		postfix(&stack1,str[i]);
	}
	while (stack1.top != NULL)
		printf("%c", pop(&stack1));
	
	return 0;
}