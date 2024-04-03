#include <iostream>
#include <string>
using namespace std;
string s1, s2;
int T, N, bomb, a[105];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> T;
	while (T--) {
		cin >> N >> s1 >> s2;
		for (int i = 0; i < N; i++) a[i] = s1[i] - '0';
		bomb = 0;
	
		for (int i = 0; i < N; i++) {
			if (i == 0 && a[i] != 0 && a[i + 1] != 0) {
				a[i]--;
				a[i + 1]--;
				bomb++;
			}
			else if (i == N - 1 && a[i] != 0 && a[i - 1] != 0) {
				a[i]--;
				a[i - 1]--;
				bomb++;
			}
			else if (i > 0 && i < N - 1 && a[i] != 0 && a[i - 1] != 0 && a[i + 1] != 0) {
				a[i]--;
				a[i - 1]--;
				a[i + 1]--;
				bomb++;
			}
		}
		cout << bomb << "\n";
	}
}