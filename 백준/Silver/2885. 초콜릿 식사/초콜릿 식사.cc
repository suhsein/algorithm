#include <iostream>
using namespace std;
int N, K, x = 1, cnt;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> K;
	while (x < K) x *= 2;
	
	if (x == K) {
		cout << x << " " << 0;
		return 0;
	}
	
	N = x;
	x /= 2;
	while (K) {
		if(x <= K) K -= x;
		x /= 2;
		cnt++;
	}

	cout << N << " " << cnt;
}