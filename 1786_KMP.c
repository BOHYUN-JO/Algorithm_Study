#include <stdio.h>
#include <string.h>
#define MAX_STR_SIZE 1000001
#define MAX_PAT_SIZE 1000001

int failure[MAX_PAT_SIZE];
char string[MAX_STR_SIZE];
char pat[MAX_PAT_SIZE];
int result=0;
int cnt[MAX_STR_SIZE];

void getfailure(char pat[])
{
	int m = strlen(pat);
	int j = 0;
	for(int i =1; i<m; i++)
	{
		int k = i;
		failure[i] = NULL;
		while(failure[i]==NULL)
		{
			if(k==0)
			{
				failure[i] = 0;
				break;
			}
			else if(pat[failure[k-1]] == pat[i])
				failure[i]= failure[k-1]+1;
			else k = failure[k-1];
		}
	}
}

void pmatch(char* string, char* pat)
{
	getfailure(pat);
	int i = 0, j=0;
	int lens = strlen(string);
	int lenp = strlen(pat);
	while(i<lens - lenp + j + 1)
	{
		if(string[i]==pat[j])
		{
			i++;
			j++;
			if(j==lenp)
			{
				cnt[result++] = i-j+1;
				j = failure[j-1];
			}
		}
		else if(j==0) i++;
		else j = j - (j - failure[j-1]);
	}

}


int main()
{
	gets(string);
	fflush(stdin);
	gets(pat);
	if(string[strlen(string)-1] == '\n') string[strlen(string)-1] = NULL;
	if(pat[strlen(pat)-1] == '\n') pat[strlen(pat)-1] = NULL;
	pmatch(string, pat);
	printf("%d\n", result);
	for(int i = 0; i < result; i++)
		printf("%d ", cnt[i]);
	
	return 0;
}
