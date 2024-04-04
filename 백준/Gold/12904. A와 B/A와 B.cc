#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
string s, t;
bool flag;
int ss, sa, sb, ta, tb;

void solve(string str, int cura, int curb) {
	if (flag) return;
	if (str.size() == ss) {
		if (str == s) {
			flag = 1;
			return;
		}
	}
	if (cura > sa && str[str.size() - 1] == 'A') 
		solve(str.substr(0, str.size() - 1), cura - 1, curb);
	if (curb > sb && str[str.size() - 1] == 'B') {
		string tmp = str.substr(0, str.size() - 1);
		reverse(tmp.begin(), tmp.end());
		solve(tmp, cura, curb - 1);
	}
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> s >> t;
	ss = s.size();
	for (auto x : s) {
		if (x == 'A') sa++;
		else if (x == 'B') sb++;
	}
	for (auto x : t) {
		if (x == 'A') ta++;
		else if (x == 'B') tb++;
	}
	solve(t, ta, tb);
	cout << flag;
}