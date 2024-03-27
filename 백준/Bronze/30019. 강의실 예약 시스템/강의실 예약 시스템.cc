#include <iostream>
#include <vector>
using namespace std;
int N, M, x, s, e;
vector<int> v;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M;
	v.resize(N + 1, 0);
	while (M--) {
		cin >> x >> s >> e;
		if (s >= v[x]) {
			v[x] = e;
			cout << "YES\n";
		}
		else cout << "NO\n";
	}
}