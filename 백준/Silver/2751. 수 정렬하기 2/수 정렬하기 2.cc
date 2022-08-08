#include <iostream>
#include <vector>
#include<algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int> a;

	int b;
	for (int i = 0; i < n; i++)
	{
		cin >> b;
		a.push_back(b);
	}

	sort(a.begin(), a.end());

	for (int i = 0; i < n; i++) {
		cout << a[i] << '\n';
	}
}