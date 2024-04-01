#include <iostream>
#include <string>
using namespace std;
int k, y;
string s, korea = "KOREA", yonsei = "YONSEI";
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> s;
	for (auto c : s) {
		if (c == korea[k]) k++;
		else if (c == yonsei[y]) y++;
		if (k == 5) {
			cout << "KOREA";
			break;
		}
		else if (y == 6) {
			cout << "YONSEI";
			break;
		}
	}
}