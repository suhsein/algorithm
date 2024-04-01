#include <iostream>
using namespace std;
int N, M, x, tmp, cnt;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M;
	while (N--) {
		cin >> x;
		if (tmp + x == M) {
			tmp = 0; cnt++;
		}
		else if (tmp + x > M) {
			tmp = x; cnt++;
		}
		else tmp += x;
	}
	if (tmp) cnt++;
	cout << cnt;
}