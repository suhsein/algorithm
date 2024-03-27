#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int R, N, score, mx;
string sk, f[51];
char arr[3] = { 'R','S','P' }, tmp[3];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> R >> sk >> N;
	for (int i = 0; i < N; i++) {
		cin >> f[i];
		for (int j = 0; j < R; j++) {
			if (sk[j] == f[i][j]) score++;
			else {
				for (int k = 0; k < 3; k++) {
					if (sk[j] == arr[k] && f[i][j] == arr[(k + 1) % 3]) {
						score += 2;
						break;
					}
				}
			}
		}
	}

	for (int j = 0; j < R; j++) {
		fill(tmp, tmp + 3, 0);
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < N; i++) {
				if (arr[k] == f[i][j]) tmp[k]++;
				else if(f[i][j] == arr[(k + 1) % 3]) tmp[k] += 2;
			}
		}
		mx += max({ tmp[0], tmp[1],tmp[2] });
	}
	cout << score << "\n" << mx;
}