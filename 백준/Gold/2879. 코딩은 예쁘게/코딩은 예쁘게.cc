#include <iostream>
#include <math.h>
#define MX 1005
using namespace std;
int N, ans, a[MX], x, mn;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) cin >> a[i];
	for (int i = 0; i < N; i++) {
		cin >> x;
		a[i] -= x;
	}

	bool flag = 1;
	while (flag) {
		flag = 0;
		for (int l = 0, r = 1; l < N; l++, r = l + 1) {
			if (!a[l]) continue;
			flag = 1; mn = a[l];
			
			while (r < N && a[l] * a[r] > 0) {
				if (abs(a[r]) < abs(mn)) mn = a[r];
				r++;
			}
			ans += abs(mn);
			for (int i = l; i < r; i++) a[i] -= mn;
			l = r - 1;
		}
	}
	
	cout << ans;
}