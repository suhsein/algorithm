#include <iostream>
using namespace std;
int N, pr, cur, ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> cur;
		if (cur >= pr) ans++;
		pr = cur;
	}
	cout << ans;
}