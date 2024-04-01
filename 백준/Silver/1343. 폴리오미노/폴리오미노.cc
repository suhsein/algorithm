#include <iostream>
#include <string>
using namespace std;
string s, ans = "";
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> s;
	int sz = s.size();
	for (int i = 0; i < sz; i++) {
		if (s[i] == '.') ans += '.';
		else {
			if (s.substr(i, 4) == "XXXX") {
				ans += "AAAA";
				i += 3;
			}
			else if (s.substr(i, 2) == "XX") {
				ans += "BB";
				i++;
			}
			else {
				cout << -1;
				return 0;
			}
		}
	}
	cout << ans;
}