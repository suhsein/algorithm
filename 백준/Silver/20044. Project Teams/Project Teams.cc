#include <iostream>
#include <algorithm>
using namespace std;
int n, arr[1000005], ans = 200005;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n;
	for (int i = 0; i < 2 * n; i++) cin >> arr[i];

	sort(arr, arr + 2 * n);

	for (int l = 0, r = 2 * n - 1, tmp = 0; l < r; l++, r--) {
		tmp = arr[l] + arr[r];
		ans = min(ans, tmp);
	}
	cout << ans;
}