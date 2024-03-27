#include <iostream>
#include <algorithm>
using namespace std;
int N, x, hz, zh;
bool odd = 1, even = 1;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N; 
	for (int i = 0; i < N; i++) {
		cin >> x;
		if (odd && x % 2 || (!odd && !(x % 2))) {
			hz++;
			odd = !odd;
		}
		if (even && !(x % 2) || (!even && (x % 2))) {
			zh++;
			even = !even;
		}
	}
	cout << max(zh, hz);
}