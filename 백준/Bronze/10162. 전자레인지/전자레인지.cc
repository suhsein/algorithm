#include <iostream>
using namespace std;
int T, btn[3] = { 300,60,10 }, ans[3] = {0,0,0};
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> T;
	for (int i = 0; i < 3; i++) {
		if (T < btn[i]) continue;
		ans[i] += T / btn[i];
		T -= btn[i] * ans[i];
	}
	if (T) cout << -1;
	else for (int i = 0; i < 3; i++) cout << ans[i] << " ";
}