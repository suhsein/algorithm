#include <iostream>
#include <algorithm>
#define MX 100005
using namespace std;
int N, arr[MX];
bool chk(int x) {
	if (arr[0] > x) return 0;
	int acc = 0, cur = 0;
	for (int i = 1; i < N; i++) {
		if (arr[i] <= x) {
			acc++;
			continue;
		}
		cur = arr[i] / x + (arr[i] % x ? 1 : 0) - 2;
		if (cur > acc) return 0;
		acc -= cur;
	}
	return 1;
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];
	sort(arr, arr + N);
	int l = arr[0], r = arr[N - 1], m = 0;
	while (l < r) {
		m = (l + r) / 2; 
		if (chk(m)) r = m;
		else l = m + 1;
	}
	cout << r;
}