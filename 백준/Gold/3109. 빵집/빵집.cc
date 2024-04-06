#include <iostream>
#include <string>
using namespace std;
int R, C, dx[3] = { -1,0,1 }, ans;
string map[10005];
bool dfs(int x, int y) {
	map[x][y] = 'x';
	if (y == C - 1) {
		ans++;
		return true;
	}
	for (int i = 0; i < 3; i++) {
		int nx = x + dx[i], ny = y + 1;
		if (nx >= 0 && nx < R && map[nx][ny] == '.') {
			if (dfs(nx, ny)) return true;
		}
	}
	return false;
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> R >> C;
	for (int i = 0; i < R; i++) cin >> map[i];
	for (int i = 0; i < R; i++) dfs(i, 0);
	cout << ans;
}