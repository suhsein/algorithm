#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
int T, N;
ll arr[205], ans[105];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> T;
	for (int tt = 1; tt <= T; tt++) {
		cin >> N;
		fill(arr, arr + 205, 0); fill(ans, ans + 105, 0);
		for (int i = 0; i < 2 * N; i++) cin >> arr[i];
		int idx = 0, target = 1;
		for (int i = 0; i < 2 * N; i++) {
			if (arr[i] == -1) continue;
			ll x = arr[i] * 4 / 3;
			target = lower_bound(arr + target, arr + 2 * N, x) - arr;
			arr[target] = -1; ans[idx++] = arr[i];
			if (idx == N) break;
		}
		cout << "Case #" << tt << ": ";
		for (int i = 0; i < N; i++) cout << ans[i] << " ";
		cout << "\n";
	}
}