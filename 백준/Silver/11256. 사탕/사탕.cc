#include <iostream>
#include <algorithm>
using namespace std;
int T, J, N, R, C, box[1005], ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> T;
	while (T--) {
		cin >> J >> N;
		ans = 0; fill(box, box + 1005, 0);
		for (int i = 0; i < N; i++) {
			cin >> R >> C;
			box[i] = R * C;
		}
		sort(box, box + N, greater<>());
		for (int i = 0; i < N; i++) {
			J -= box[i]; ans++;
			if (J <= 0) break;
		}
		cout << ans << "\n";
	}
}