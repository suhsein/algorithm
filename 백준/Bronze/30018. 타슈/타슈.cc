#include <iostream>
#include <vector>
using namespace std;
int N, b, ans;
vector<int> a;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	a.resize(N); 
	for (int i = 0; i < N; i++) cin >> a[i];
	for (int i = 0; i < N; i++) {
		cin >> b;
		int tmp = a[i] - b;
		if (tmp > 0) ans += tmp;
	}
	cout << ans;
}