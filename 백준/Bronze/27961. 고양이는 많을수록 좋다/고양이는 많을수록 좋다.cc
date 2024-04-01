#include <iostream>
#define ll long long
using namespace std;
ll N, sum, cnt, idx;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	if (N <= 2) {
		cout << N;
		return 0;
	}
	sum = 2; cnt = 1; idx = 3;
	while (1) {
		if (sum >= N) break;
		cnt *= 2; idx++;
		sum += cnt;
	}
	cout << idx - 1;
}