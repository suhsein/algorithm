#include <iostream>
using namespace std;
int a, b, c;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	while (cin >> a >> b >> c) {
		if (c - b > b - a) cout << c - b - 1 << "\n";
		else cout << b - a - 1 << "\n";
	}
}