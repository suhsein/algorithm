#include <iostream>
#include <algorithm>
#define MX 500005
using namespace std;
int N, arr[MX], ans, sum;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) cin >> arr[i];
	sort(arr, arr + N);
	int l = 0, r = N - 1;
	while (l < r) {
		arr[l]--;
		if (!arr[l]) l++;
		r--;
		ans++;
	}
	cout << ans;
}