// [Silver V] Title: 귀찮음, Time: 48 ms, Memory: 3872 KB, Score: 30 point
#include <iostream>
#include <algorithm>
#define ll long long
using namespace std;
int n, arr[500005];
ll sum, ans;

int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		sum += arr[i];
	}
	sort(arr, arr + n);
	for (int i = 0; i < n; i++) {
		sum -= arr[i];
		ans += sum * arr[i];
	}

	cout << ans;
}
