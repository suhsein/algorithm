#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
string s, t;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> s >> t;
	while (1) {
		if (t.back() == 'A') {
			t.pop_back();
		}
		else if (t.back() == 'B') {
			t.pop_back();
			reverse(t.begin(), t.end());
		}
		if (t.size() == s.size()) {
			cout << (t == s ? 1 : 0);
			return 0;
		}
	}
}