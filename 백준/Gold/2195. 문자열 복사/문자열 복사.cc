#include <iostream>
#include <string>
using namespace std;
string S, P;
int ans;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> S >> P;
	int ss = S.size(), ps = P.size();
	for (int i = 0; i < ps; i++) {
		int mx = i;
		for (int j = 0; j < ss; j++) {
			if (S[j] != P[i]) continue;
			int x = j, y = i;
			while (x < ss && y < ps && S[x] == P[y]) {
				x++; y++;
			}
			if (y > mx) mx = y;
		}
		i = mx - 1; ans++;
	}
	cout << ans;
}