#include <iostream>
#include <algorithm>
#include <vector>
#define X first
#define Y second
using namespace std;
vector<pair<int, int>> v;
int N, x, y, s, e, ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x >> y;
		v.push_back({ x,y });
	}
	sort(v.begin(), v.end());
	s = v[0].X, e = v[0].Y;
	for (int i = 1; i < N; i++) {
		if (v[i].X <= e) {
			if (v[i].Y > e) e = v[i].Y;
		}
		else {
			ans += (e - s);
			s = v[i].X;
			e = v[i].Y;
		}
	}
	ans += (e - s);
	cout << ans;
}