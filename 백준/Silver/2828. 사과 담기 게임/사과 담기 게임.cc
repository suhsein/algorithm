#include <iostream>
using namespace std;
int N, M, J, cur, pr = 1, l, r, diff, ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M >> J;
	l = 1, r = M;
	while (J--) {
		cin >> cur;
		if (cur == pr) continue;
		if (cur > r) {
			diff = cur - r;
			ans += diff; l += diff; r += diff;
		}
		else if (cur < l) {
			diff = l - cur;
			ans += diff;
			l -= diff; r -= diff;
		}
		pr = cur;
	}
	cout << ans;
}