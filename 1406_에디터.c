#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100001
typedef struct list_node* list_pointer;

typedef struct list_node{
	char data;
	list_pointer next;
	list_pointer prev;
}node;

list_pointer ptr = NULL;
list_pointer cur = NULL;

void left()
{
	if (cur == ptr)
		return;
	cur = cur->prev;

}

void right()
{
	if (cur->next == NULL)
		return;
	cur = cur->next;
}

void del()
{
	list_pointer temp;
	temp = cur;
	if (cur == ptr)
		return;
	if (cur->next == NULL)
	{
		cur->prev->next = NULL;
		cur = cur->prev;
		free(temp);
	}
	else {
		cur->prev->next = cur->next;
		cur->next->prev = cur->prev;
		cur = cur->prev;
		free(temp);
	}
}

void init()
{
	ptr = (list_pointer)malloc(sizeof(node));
	ptr->next = NULL;
}

void add(char p)
{
	list_pointer temp;
	temp = (list_pointer)malloc(sizeof(node));
	temp->data = p;
	if (cur->next == NULL)
	{
		temp->next = NULL;
		temp->prev = cur;
		cur->next = temp;
		cur = temp;
	}
	else
	{
		temp->next = cur->next;
		temp->prev = cur;
		cur->next->prev = temp;
		cur->next = temp;
		cur = temp;
	}
	
}

int main()
{
	int i,M;
	char temp;
	char data;
	ptr = (list_pointer)malloc(sizeof(node));
	ptr->next = NULL;
	ptr->prev = NULL;
	cur = ptr;
	while (1)
	{
		temp = getchar();
		if (temp == '\n')
			break;
		add(temp);
	}
	scanf("%d", &M);
	getchar();
	for (i = 0; i < M; i++)
	{
		scanf("%c", &temp);
		if (temp == 'L')
			left(ptr, cur);
		else if (temp == 'D')
			right(ptr, cur);
		else if (temp == 'B')
			del(ptr, cur);
		else
		{
			getchar();
			scanf("%c", &data);
			add(data);
		}
		getchar();
	}
	
	while(1)
	{
		ptr = ptr->next;
		if (ptr == NULL)
			break;
		printf("%c", ptr->data);
	}

	return 0;
}