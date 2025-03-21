#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, S, x, res = 1e6;
vector<int> v;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> S; N++; v.resize(N);
	for (int i = 1; i < N; i++) {
		cin >> x;
		v[i] = v[i - 1] + x;
	}
	sort(v.begin(), v.end());
	for (int l = 0, r = 0; l < N; l++) {
		while (r < N && v[r] - v[l] < S) r++;
		if (r == N) break;
		res = min(res, r - l);
	}
	if (res == 1e6) cout << 0;
	else cout << res;
}