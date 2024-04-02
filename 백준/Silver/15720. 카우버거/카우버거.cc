#include <iostream>
#include <algorithm>
#define MX 1005
using namespace std;
int B, C, D, sum, ans, b[MX], c[MX], d[MX];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> B >> C >> D;
	for (int i = 0; i < B; i++) {
		cin >> b[i];
		sum += b[i];
	}
	for (int i = 0; i < C; i++) {
		cin >> c[i];
		sum += c[i];
	}
	for (int i = 0; i < D; i++) {
		cin >> d[i];
		sum += d[i];
	}
	sort(b, b + B, greater<>());
	sort(c, c + C, greater<>());
	sort(d, d + D, greater<>());

	int mn = min({ B,C,D });
	for (int i = 0; i < mn; i++) {
		int tmp = (b[i] + c[i] + d[i]) * 0.9;
		ans += tmp;
	}
	for (int i = mn; i < max({ B,C,D }); i++) {
		if (B >= i) ans += b[i];
		if (C >= i) ans += c[i];
		if (D >= i) ans += d[i];
	}
	cout << sum << "\n" << ans;
}