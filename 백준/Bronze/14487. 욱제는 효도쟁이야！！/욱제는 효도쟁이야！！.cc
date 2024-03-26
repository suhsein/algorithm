#include <iostream>
using namespace std;
int N, x, mx, ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	while(N--) {
		cin >> x;
		if (x > mx) mx = x;
		ans += x;
	}
	ans -= mx;
	cout << ans;
}