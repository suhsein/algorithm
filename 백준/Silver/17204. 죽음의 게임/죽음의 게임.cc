#include <iostream>
#include <queue>
using namespace std;
int N, K, x, edge[160], ans;
bool visit[160];
queue<int> q;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		cin >> x;
		edge[i] = x;
	}
	q.push(0); visit[0] = 1;
	while (!q.empty()) {
		int cur = q.front(); q.pop();
		if (cur == K) break;
		int nxt = edge[cur];
		if (visit[nxt]) {
			cout << -1;
			return 0;
		}
		q.push(edge[cur]); visit[nxt] = 1; ans++;
	}
	cout << ans;
}