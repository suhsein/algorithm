#include <iostream>
#include <math.h>
using namespace std;
int T, N, x, ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	T = 2;
	while (T--) {
		for (int i = 0; i < N; i++) {
			cin >> x;
			ans += abs(x);
		}
	}
	cout << ans;
}