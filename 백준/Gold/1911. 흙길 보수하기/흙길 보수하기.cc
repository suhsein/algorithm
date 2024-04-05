#include <iostream>
#include <algorithm>
#include <vector>
#define X first
#define Y second
using namespace std;
int N, L, a, b, ans, tmp;
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
		if(v[i].X > tmp) tmp = v[i].X;
		while (tmp < v[i].Y) {
			tmp += L;
			ans++;
		}
	}
	cout << ans;
}