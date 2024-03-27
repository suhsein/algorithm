#include <iostream>
using namespace std;
int N;
int factorial(int x) {
	if (x == 1) return 1;
	return x * factorial(x - 1);
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	cout << factorial(N);
}