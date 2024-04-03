#include <iostream>
#define MX 15
using namespace std;
int N, dx[8] = { -1,-1,-1,0,0,1,1,1 }, dy[8] = { -1,0,1,-1,1,-1,0,1 }, ans[MX][MX];
char map[MX][MX], open[MX][MX];
bool flag;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) cin >> map[i][j];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> open[i][j];
			if (open[i][j] == 'x' && map[i][j] == '*') flag = 1;
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] == '*') {
				for (int k = 0; k < 8; k++) {
					int nx = i + dx[k], ny = j + dy[k];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					ans[nx][ny]++;
				}
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (flag && map[i][j] == '*') cout << '*';
			else if (open[i][j] == 'x') {
				if (map[i][j] == '*') flag = 1;
				else cout << ans[i][j];
			}
			else cout << '.';
		}
		cout << "\n";
	}
}