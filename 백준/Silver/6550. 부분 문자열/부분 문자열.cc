#include <iostream>
#include <string>
using namespace std;
string s, t;
int sz;
bool flag;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	while (cin >> s >> t) {
		sz = s.size(); flag = 1;
		for (int i = 0, j = 0; i < t.size(); i++) {
			if (s[j] == t[i]) j++;
			if (j == sz) {
				flag = 0;
				break;
			}
		}
		if (flag) cout << "No\n";
		else cout << "Yes\n";
	}
}