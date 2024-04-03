#include <iostream>
#define MX 105
using namespace std;
int N, bomb, dx[8] = { -1,-1,-1,0,0,1,1,1 }, dy[8] = { -1,0,1,-1,1,-1,0,1 };
char map[MX][MX];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) cin >> map[i][j];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (map[i][j] != '#') continue;
			bool flag = 1;
			for (int k = 0; k < 8; k++) {
				int nx = i + dx[k], ny = j + dy[k];
				if (map[nx][ny] == '#') continue;
				if (map[nx][ny] == '0') {
					flag = 0;
					break;
				}	
			}
			if (flag) {
				bomb++;
				for (int k = 0; k < 8; k++) {
					int nx = i + dx[k], ny = j + dy[k];
					if (map[nx][ny] == '#') continue;
					map[nx][ny] -= 1;
				}
			}
		}
	}
	cout << bomb;
}