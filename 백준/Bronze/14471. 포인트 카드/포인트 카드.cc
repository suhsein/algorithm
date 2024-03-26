#include <iostream>
#include <algorithm>
#include <vector>
#define MX 1005
using namespace std;
int N, M, a, b, cnt, ans;
vector<int> v;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		if (a >= N) cnt++;
		else v.push_back(N - a);
	}
	if (cnt >= M - 1) {
		cout << ans;
		return 0;
	}
	sort(v.begin(), v.end());
	for (auto x : v) {
		ans += x;
		cnt++;
		if (cnt >= M - 1) break;
	}
	cout << ans;
}