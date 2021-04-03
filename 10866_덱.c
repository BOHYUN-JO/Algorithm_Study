#include <stdio.h>
#include <string.h>
#define MAX_DEQUE_SIZE 10000

typedef struct{
	int key;
}element;

element deque[MAX_DEQUE_SIZE];

int rear =1;
int front = 0;
int deque_size =0;

void push_front(int data)
{
	deque[front].key = data;
	front = ((front-1) + MAX_DEQUE_SIZE)% MAX_DEQUE_SIZE;
	deque_size++;
}

void push_back(int data)
{
	deque[rear].key = data;
	rear = (rear+1)%MAX_DEQUE_SIZE;
	deque_size++;
}

int pop_front()
{
	if(deque_size ==0)
		return -1;
	front = (front+1) %MAX_DEQUE_SIZE;
	deque_size--;
	return deque[front].key;
}

int pop_back()
{
	if(deque_size ==0)
		return -1;
	rear = ((rear-1)+MAX_DEQUE_SIZE)%MAX_DEQUE_SIZE;
	deque_size--;
	return deque[rear].key;
}

int size()
{
	return deque_size;
}

int empty()
{
	if(deque_size ==0)
		return 1;
	else return 0;
}

int dfront()
{
	if(deque_size ==0)
		return -1;
	int temp = (front+1) %MAX_DEQUE_SIZE;
	return deque[temp].key;
}

int back()
{
	if(deque_size ==0)
		return -1;
	int temp= ((rear-1)+MAX_DEQUE_SIZE)%MAX_DEQUE_SIZE;
	return deque[temp].key;
}

int main()
{
	int N,i,data;
	char arr[12];
	scanf("%d", &N);
	for(i=0; i<N; i++)
	{
		scanf("%s", arr);
		if(!strncmp(arr,"size", 4))
			printf("%d\n", size());
		else if(!strncmp(arr,"back", 4))
			printf("%d\n", back());
		else if(!strncmp(arr,"front",5))
			printf("%d\n", dfront() );
		else if(!strncmp(arr,"pop_front", 9))
			printf("%d\n", pop_front());
		else if(!strncmp(arr,"pop_back", 8))
			printf("%d\n", pop_back());
		else if(!strncmp(arr,"empty", 5))
			printf("%d\n", empty());
		else if(!strncmp(arr,"push_back", 9))
		{
			scanf("%d", &data);
			push_back(data);
		}
		else
		{
			scanf("%d", &data);
			push_front(data);
		}
	}
	return 0;
	
}
