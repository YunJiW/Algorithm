#include <iostream>
#include <string>

using namespace std;


int main()
{
	int a, B, V;
	int day = 1;
	cin >> a >> B >> V;


	if ((V - a) % (a - B) == 0)
		day = (V - a) / (a - B);
	else
		day = (V - a) / (a - B) + 1;
	cout << day+1;

	return 0;
	
}