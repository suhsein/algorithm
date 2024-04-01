#include <iostream>
#include <vector>
using namespace std;
int t, n;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> t;
	while (t--) {
		cin >> n;
		vector<int> v(n,0);
		for (int i = 0; i < n; i++) cin >> v[i];
		int num = 1, idx = 0;
		for (int i = 0; i < n; i++) {
			while (v[idx] == num) num++;
			num++; idx++;
		}
		cout << num - 1 << "\n";
	}
}