#include <iostream>
using namespace std;
int N, x, y;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> x >> y;
	if (N == 1) {
		cout << 0;
		return 0;
	}
	else if (N == 2) {
		cout << 2;
		return 0;
	}
	if (x == 1 || x == N) {
		if (y == 1 || y == N)  cout << 2;
		else cout << 3;
	}
	else if (y == 1 || y == N) {
		if (x == 1 || x == N) cout << 2;
		else cout << 3;
	}
	else cout << 4;
}