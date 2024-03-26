#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
int N, b, c;
ll ans, cur, B, C1, C2;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> b >> c;

	// B 현재 공장에서 b 금액으로 사야만하는 라면 갯수
	// C1 다음 공장에서 c 금액으로 살 수 있는 라면 갯수
	// C2 다다음 공장에서 c 금액으로 살 수 있는 라면 갯수
	if (b < c) c = b;
	for (int i = 0; i < N; i++) {
		cin >> cur;
		B = cur - min(C1, cur); // C로 바꾸고 남은 나머지
		ans += (B * b) + (min(C1, cur) * c); 
		C1 = min(C2, cur) + B; // 순서 + 1 -> 다다음 공장이 다음 공장이 되야하므로
		C2 = B;
	}
	cout << ans;
}