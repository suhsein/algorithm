#include <iostream>
#include <string>
using namespace std;
string s;
int k;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		if (i > 0 && s[i] > s[i - 1]) continue;
		k++;
	}
	cout << k;
}