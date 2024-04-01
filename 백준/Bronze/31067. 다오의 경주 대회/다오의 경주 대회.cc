#include <iostream>
using namespace std;
int N, K, pr = -1, cur, cnt;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> K;
	while(N--) {
		cin >> cur;
		if (pr != -1) {
			if (cur <= pr) {
				if (cur + K <= pr) {
					cout << -1;
					return 0;
				}
				else {
					cnt++; cur += K;
				}
			}
		}
		pr = cur;
	}
	cout << cnt;
}