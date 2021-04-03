#include <stdio.h>
#include <string.h>
#define MAX_STACK_SIZE 50


typedef struct {
	char key;
}element;

element stack[MAX_STACK_SIZE];

int top = -1;
int stack_size = 0;

void push(char data)
{
	stack[++top].key = data;
	stack_size++;
}

int pop()
{
	if (stack_size == 0)
		return -1;
	stack_size--;
	return stack[top--].key;
}

int size()
{
	return stack_size;
}

int empty()
{
	if (stack_size == 0)
		return 1;
	else return 0;
}


int main()
{
	int N, i, data, flag = 1;
	char temp = 'a';
	char trash;
	scanf("%d", &N);
	getchar();
	for (i = 0; i < N; i++)
	{
		top = -1;
		stack_size = 0;
		while (1)
		{
			scanf("%c", &temp);
			if (temp == '\n')
				break;
			if (temp == '(')
				push(temp);
			else
			{
				if (stack[top].key == '(')
					pop();
				else
					push(temp);
			}
		}
		if (stack_size == 0)
			printf("YES\n");
		else printf("NO\n");

	}

	return 0;

}
