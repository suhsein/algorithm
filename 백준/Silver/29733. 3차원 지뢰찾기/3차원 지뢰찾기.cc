#include <iostream>
#define MX 105
using namespace std;
int R, C, H;
char x;
int ans[MX][MX][MX];
int dx[26] = { -1,-1,-1,0,0,0,1,1,1,-1,-1,-1,0,0,1,1,1,-1,-1,-1,0,0,0,1,1,1 };
int dy[26] = { -1,0,1,-1,0,1,-1,0,1,-1,0,1,-1,1,-1,0,1,-1,0,1,-1,0,1,-1,0,1 };
int dz[26] = { -1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1 };
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> R >> C >> H;
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				cin >> x;
				if (x == '*') {
					ans[i][j][k] = -30;
					for (int dir = 0; dir < 26; dir++) {
						int nz = i + dz[dir], nx = j + dx[dir], ny = k + dy[dir];
						if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= R || ny >= C) continue;
						ans[nz][nx][ny]++;
					}
				}
			}
		}
	}
	for (int i = 0; i < H; i++) {
		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				if (ans[i][j][k] < 0) cout << '*';
				else cout << ans[i][j][k] % 10;
			}
			cout << "\n";
		}
	}
}