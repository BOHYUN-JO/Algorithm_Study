#include <stdio.h>
#define MAX 1000

typedef struct 
{
  int key;
  int idx;
}element;

element queue[MAX];

int front =0;
int rear =0;

 
void push_front(element ballon)
{
   front = (front + MAX- 1)%MAX;
   queue[front] = ballon;
  
}

void push_back(element ballon)
{
	queue[rear] = ballon;
    rear = (rear+1)%MAX;
}

element pop_front()
{
    element temp = queue[front];
    front = (front + 1)%MAX;
    return temp;
}

element pop_back()
{
    rear = (rear - 1 + MAX)%MAX;
    return queue[rear];
}

int main()
{
  	int N,i;
  	element next;
  	scanf("%d",&N);
   	for(i=0; i<N; i++)
  	{
    	int target;
    	scanf("%d", &target);
    	queue[i].key = target;
    	queue[i].idx = i+1;
    	rear = (rear+1)%MAX;
  	}
  	
  	for(i=0; i<N; i++)
  	{
  		
  		next = pop_front();
  		printf("%d ", next.idx);
  	
  		if(next.key>0)
  		{
  			next.key -= 1;
  			while(next.key--)
  				push_back(pop_front());
		}
		else 
		{
			next.key = next.key*(-1);
			while(next.key--)
				push_front(pop_back());
		}
	}
  	  	
  	return 0;
}

