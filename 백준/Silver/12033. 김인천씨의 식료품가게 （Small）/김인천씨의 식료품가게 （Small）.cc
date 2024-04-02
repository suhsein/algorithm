#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
int T, N;
ll arr[10], ans[5];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> T;
	for (int tt = 1; tt <= T; tt++) {
		cin >> N;
		fill(arr, arr + 10, 0); fill(ans, ans + 5, 0);
		for (int i = 0; i < 2 * N; i++) cin >> arr[i];
		int idx = 0;
		for (int i = 0; i < 2 * N; i++) {
			if (arr[i] == -1) continue;
			ll x = arr[i] * 4 / 3;
			for (int j = i + 1; j < 2 * N; j++) {
				if (arr[j] == x) {
					arr[j] = -1;
					ans[idx++] = arr[i];
					break;
				}
			}
			if (idx == N) break;
		}
		cout << "Case #" << tt << ": ";
		for (int i = 0; i < N; i++) cout << ans[i] << " ";
		cout << "\n";
	}
}