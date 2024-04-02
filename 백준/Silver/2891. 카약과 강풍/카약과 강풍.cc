#include <iostream>
using namespace std;
int N, S, R, x, ans;
int a[15];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> S >> R;
	while (S--) {
		cin >> x;
		a[x]--;
	}
	while (R--) {
		cin >> x;
		a[x]++;
	}
	for (int i = 1; i <= N; i++) {
		if (a[i] < 0) {
			if (i > 1 && a[i - 1] > 0) {
				a[i]++;
				a[i - 1]--;		
			}
			else if (i < N && a[i + 1] > 0) {
				a[i]++;
				a[i + 1]--;
			}
		}
	}
	for (int i = 1; i <= N; i++)if (a[i] < 0) ans++;
	cout << ans;
}