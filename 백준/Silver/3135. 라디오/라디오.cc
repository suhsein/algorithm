#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;
int A, B, N, x, mn;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> A >> B >> N;
	mn = abs(A - B);
	for (int i = 0; i < N; i++) {
		cin >> x;
		mn = min(mn, abs(B - x) + 1);
	}
	cout << mn;
}