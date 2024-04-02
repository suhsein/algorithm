#include <iostream>
#include <string>
using namespace std;
string s, UCPC="UCPC";
int idx = 0;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	getline(cin, s);
	for (auto c : s) {
		if (c == UCPC[idx]) idx++;
		if (idx == 4) break;
	}
	cout << "I " << ((idx == 4) ? "love" : "hate") << " UCPC";
}