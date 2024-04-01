#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, M, x, midx;
vector<int> v;

bool chk(int m) {
	int cnt = m - x;
	for (int i = midx; i < N; i++) {
		if (v[i] >= m) cnt -= (v[i] - m + 1);
		if (cnt < 0) return false;
	}
	return true;
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> x;
	N--; M += x;
	v.resize(N, 0);

	for (int i = 0; i < N; i++) {
		cin >> v[i];
		M += v[i];
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < N; i++) {
		if (v[i] >= x) {
			midx = i;
			break;
		}
	}
	int l = x, r = M, m;

	while (l < r) {
		m = (l + r) / 2;
		if (chk(m)) r = m;
		else l = m + 1;
	}

	cout << r - x;
}