#include <iostream>
#include <algorithm>
#include <list>

using namespace std;

int main()
{
	int n,k,idx;
	cin >> n >> k;
	list<int> list1;
	
	for(int i=0; i< n; i++)
	{
		list1.push_back(i+1);
	}
	
	list<int>::iterator it = list1.begin();
	for(int i=0; i< k-1 ; i++)
		it++;
	cout<< '<';
	
	while(n > 0 ){
		if(n==1)
		{
			cout<< *it;
			break;
		}
		cout << *it << ", ";
		it = list1.erase(it);
		if(it == list1.end())
			it = list1.begin();
		n--;
		for(int i=0; i<k-1; i++){
			it++;
			if(it == list1.end())
				it = list1.begin();
		}	
	}	
	
	cout << '>';
	
	
}
