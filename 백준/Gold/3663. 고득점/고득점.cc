#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int T, ans, shft, n;
string s;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> T;
	while (T--) {
		cin >> s;
		ans = 0;
		n = s.size();
		shft = n - 1;

		for (auto c : s) ans += min(c - 'A', 'Z' - c + 1);
		for (int i = 0; i < n; i++) {
			if (s[i] == 'A') {
				int tmp = i;
				while (tmp < n && s[tmp] == 'A') tmp++;
				int l = (i == 0) ? 0 : i - 1;
				int r = n - tmp;
				shft = min(shft, l + r + min(l, r));
			}
		}
		ans += shft;
		cout << ans << "\n";
	}
}