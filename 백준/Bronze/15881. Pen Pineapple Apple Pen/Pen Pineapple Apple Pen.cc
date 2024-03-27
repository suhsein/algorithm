#include <iostream>
#include <string>
using namespace std;
int n, ans, idx;
string ppap, PPAP= "PAp";
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n >> ppap;
	for (int l = 0, r = 1, cnt = 0; l < n - 3; l++, r = l + 1, cnt = 0) {
		if (ppap[l] != 'p') continue;
		while (l < n - 3) {
			idx = 0;
			while (r < n && ppap[r] == PPAP[idx]) { r++; idx++; }
			if (idx == 3) cnt++;
			while (r < n - 3 && ppap[r] != 'p') r++;
			l = r; r = l + 1;
		}
		if (cnt > ans) ans = cnt;
	}
	cout << ans;
}