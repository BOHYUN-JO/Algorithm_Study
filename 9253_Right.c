#include <stdio.h>
#include <string.h>

int failure[200002];

void getfailure(char* pat)
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
int pmatch(char* string, char* pat)
{
	getfailure(pat);
	int i = 0, j=0, flag=0;
	int lens = strlen(string);
	int lenp = strlen(pat);
	while(i<lens - lenp + j + 1)
	{
		if(string[i]==pat[j])
		{
			i++;
			j++;
			if(j==lenp)
				flag =1;			
		}
		else if(j==0) i++;
		else j = j - (j - failure[j-1]);
	}
	return flag;
}

int main()
{
	int flag1, flag2;
	char A[100001];
	char B[100001];
	char C[200001];
	gets(A);
	gets(B);
	gets(C);
	flag1 = pmatch(A,C);
	flag2 = pmatch(B,C);
	
	if(flag1==1 && flag2 ==1)
		printf("YES\n");
	else printf("NO\n");
	
	return 0;
	
}
