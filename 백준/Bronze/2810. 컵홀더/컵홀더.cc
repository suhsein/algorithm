#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
int N, ans, cnt;
string seat;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> seat;
	for (auto c : seat) {
		if (c == 'S') ans++;
		else {
			if (!cnt) cnt++;
			else {
				cnt = 0;
				ans++;
			}
		}
	}
	cout << min(N, ans + 1);
}