#include <iostream>
using namespace std;
int A, B, C, M, ans, t, day = 24;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> A >> B >> C >> M;
	
	while (day--) {
		if (M - t < A) {
			t -= C;
			if (t < 0) t = 0;
		}
		else {
			t += A;
			ans += B;
		}
	}
	cout << ans; 
}