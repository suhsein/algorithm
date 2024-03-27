#include <iostream>
using namespace std;
int N, x, pr, cnt, mx;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x;
		if (x > pr) {
			if (cnt > mx) mx = cnt;
			cnt = 0;
			pr = x;
		}
		else cnt++;
	}
	if (cnt > mx) mx = cnt;
	cout << mx;
}