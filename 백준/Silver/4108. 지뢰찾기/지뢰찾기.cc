#include <iostream>
#include <string>
#define MX 105
using namespace std;
int R, C, dx[8] = { -1,-1,-1,0,0,1,1,1 }, dy[8] = { -1,0,1,-1,1,-1,0,1 }, ans[MX][MX];
string map[MX];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	while (1) {
		cin >> R >> C;
		if (!R && !C) return 0;
		for (int i = 0; i < MX; i++) fill(ans[i], ans[i] + MX, 0);
		for (int i = 0; i < R; i++) cin >> map[i];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k], ny = j + dy[k];
						if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
						ans[nx][ny] ++;
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') cout << '*';
				else cout << ans[i][j];
			}
			cout << "\n";
		}
	}
}