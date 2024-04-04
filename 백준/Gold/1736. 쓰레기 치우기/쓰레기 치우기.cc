#include <iostream>
#include <algorithm>
#define MX 105
using namespace std;
int N, M, map[MX][MX], cnt, ans;

void solve(int x, int y) {
	for (int i = x; i < N; i++) {
		for (int j = y; j < M; j++) {
			if (map[i][j]) {
				map[i][j] = 0;
				cnt--;
				if (!cnt) return;
				solve(i, j);
				return;
			}
		}
	}
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> map[i][j];
			if (map[i][j]) cnt++;
		}
	}

	while (cnt) {
		if (map[0][0]) {
			map[0][0] = 0;
			cnt--;
		}
		solve(0, 0);
		ans++;
	}
	cout << ans;
}