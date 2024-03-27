#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int N, ans;
vector<int> v;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N; 
	v.resize(N);
	for (int i = 0; i < N; i++) {
		cin >> v[i];
		ans += v[i];
	}
	if (!(ans % 2)) {
		cout << ans;
		return 0;
	}
	sort(v.begin(), v.end());
	for (auto x : v) {
		if (x % 2) {
			ans -= x;
			break;
		}
	}
	cout << ans;
}