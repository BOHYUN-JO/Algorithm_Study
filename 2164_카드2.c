#include <stdio.h>
#include <string.h>
#define MAX_DEQUE_SIZE 500000

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
	scanf("%d", &N);
	for(i=0; i<N; i++) 
		push_back(N-i);
	while(deque_size != 1)
	{
		pop_back();
		push_front(pop_back());
	}
	printf("%d", pop_back());
	
	return 0;
	
}
