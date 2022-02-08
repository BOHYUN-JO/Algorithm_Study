#include <stdio.h>
#define MAX 51

// change
typedef struct 
{
  int key;
}element;

element queue[MAX];
int front =0;
int rear =0;
int ans =0;
 
void push_front(int num)
{
   front = (front + MAX- 1)%MAX;
   queue[front].key = num;
}

void push_back(int num)
{
	queue[rear].key = num;
    rear = (rear+1)%MAX;
}

int pop_front()
{
    int temp = queue[front].key;
    front = (front + 1)%MAX;
    return temp;
}

int pop_back()
{
    rear = (rear - 1 + MAX)%MAX;
    return queue[rear].key;
}

int left(int target)
{
    int idx = front;
    int cnt = 0;
    while(1)
    {
    	if(queue[idx].key == target)
    	   break;
    	idx = (idx + 1)%MAX;
    	cnt++;
    }
    return cnt;
}

int right(int target)
{
    int idx = (rear+MAX-1)%MAX;
    int cnt = 0;
    while(1)
    {
		if(queue[idx].key == target)
      	   	break;
      	idx = (idx+MAX-1)%MAX;
		cnt++;
    }
    return cnt + 1;
}

void circular(int target)
{
    int ldist = left(target);
    int rdist = right(target);
    if(ldist < rdist)
    {
   	  	ans += ldist;
    	while(ldist--)
      	   	push_back(pop_front());
      	
    }
    else
    {
      	ans += rdist;
      	while(rdist--)
	       	 push_front(pop_back());
      	
    }
    pop_front();
}

int main()
{
  	int N, M,i;
  	scanf("%d %d",&N,&M);
  	for(i=0; i<N; i++)
  		push_back(i+1);
   	for(i=0; i<M; i++)
  	{
    	int target;
    	scanf("%d", &target);
    	circular(target);
  	}
  	printf("%d\n",	ans);
  	
  	return 0;
}


