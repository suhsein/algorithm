#include <iostream>
#include <algorithm>
#define MX 10005
using namespace std;
int N, K, arr[MX], dist[MX], ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> K;
	for (int i = 0; i < N; i++) cin >> arr[i];
	sort(arr, arr + N);
	for (int i = 1; i < N; i++) dist[i - 1] = arr[i] - arr[i - 1];
	sort(dist, dist + N - 1);
	for (int i = 0; i < N - K; i++) ans += dist[i];
	cout << ans;
}