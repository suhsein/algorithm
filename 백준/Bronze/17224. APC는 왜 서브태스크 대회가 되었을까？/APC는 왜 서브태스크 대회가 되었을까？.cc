#include <iostream>
#include <vector>
#include <algorithm>
#define X first
#define Y second
using namespace std;
int N, L, K, a, b, cnt, ans;
vector<pair<int, int>> v;
bool cmp(pair<int, int>& a, pair<int, int> &b) {
	if (a.Y == b.Y) return a.X < b.X;
	return a.Y < b.Y;
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> L >> K;
	if (!K) {
		cout << 0;
		return 0;
	}
	v.resize(N);
	for (int i = 0; i < N; i++) {
		cin >> a >> b;
		v[i] = { a,b };
	}
	sort(v.begin(), v.end(), cmp);
	for (auto c : v) {
		if (c.Y <= L) {
			ans += 140;
			cnt++;
		}
		else if (c.X <= L) {
			ans += 100;
			cnt++;
		}
		if (cnt == K) break;
	}
	cout << ans;
}