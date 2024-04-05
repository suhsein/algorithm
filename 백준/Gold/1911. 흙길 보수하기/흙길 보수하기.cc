#include <iostream>
#include <algorithm>
#include <vector>
#define X first
#define Y second
using namespace std;
int N, L, a, b, ans, tmp, cnt;
vector<pair<int, int>> v;

int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> L;

	for (int i = 0; i < N; i++) {
		cin >> a >> b;
		v.push_back({ a,b });
	}

	sort(v.begin(), v.end());
	for (int i = 0; i < N; i++) {
		if (v[i].X > tmp) tmp = v[i].X;
		if (tmp < v[i].Y) {
			cnt = (v[i].Y - tmp) / L;
			if ((v[i].Y - tmp) % L) cnt++;
			ans += cnt;
			tmp += cnt * L;
		}
	}
	cout << ans;
}