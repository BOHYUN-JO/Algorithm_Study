#include <stdio.h>

typedef struct {
	char key;
}element;

element stack[100000];
int top = -1;
int size = 0;

void push(char data)
{
	size++;
	stack[++top].key = data;
}

int main()
{
	char data;
	int stick = 0;
	int sum = 0;
	while (1)
	{
		scanf("%c", &data);
		if (data == '\n')
			break;
		if (size == 0)
			push(data);
		else 
		{
			if (data == '(')
			{
				push(data);
				if (stack[top - 1].key == '(')
					stick++;
				else	continue;
			}
			else
			{
				push(data);
				if (stack[top - 1].key == '(')
					sum += stick;
				else
				{
					stick--;
					sum += 1;
				}
			}
		}
	}

	printf("%d", sum);
	return 0;
}
