#include <iostream>
#include <algorithm>
using namespace std;
int N, x, ans, v[100005];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) cin >> v[i];
	sort(v, v + N, greater<>());
	for (int i = 0; i < N; i++) {
		int tmp = v[i] + i + 1;
		if (tmp > ans) ans = tmp;
	}
	cout << ans + 1;
}