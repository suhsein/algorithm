#include <iostream>
using namespace std;
int N, x, idx = 1, ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	while(N--) {
		cin >> x;
		if (x == idx) idx++;
		else ans++;
	}
	cout << ans;
}