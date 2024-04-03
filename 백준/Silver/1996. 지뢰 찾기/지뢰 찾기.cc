#include <iostream>
#include <string>
#define MX 1005
using namespace std;
int N, dx[8] = {-1,-1,-1,0,0,1,1,1}, dy[8] = {-1,0,1,-1,1,-1,0,1}, ans[MX][MX];
string map[MX];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) cin >> map[i];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] != '.') {
				for (int k = 0; k < 8; k++) {
					int nx = i + dx[k], ny = j + dy[k];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					ans[nx][ny] += (map[i][j] - '0');
				}
			}
		}
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] != '.') cout << '*';
			else if (ans[i][j] >= 10) cout << 'M';
			else cout << ans[i][j];
		}
		cout << "\n";
	}
}