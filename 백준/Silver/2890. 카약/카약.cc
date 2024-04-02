#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
string s;
int R, C, cnt, num, x = 1;
vector<pair<int, int>> v;
int ord[10];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> R >> C;

	while (R--) {
		cin >> s;
		cnt = num = 0;
		for (int i = 0; i < C; i++) {
			if ((((s[i] == '.')|| (s[i] == 'F')) && (s[i - 1] >= '1' && s[i - 1] <= '9')) || cnt) cnt++;
			if (s[i] >= '1' && s[i] <= '9') num = s[i] - '0';
		}
		if (!cnt) continue;
		v.push_back({ cnt, num });
	}
	sort(v.begin(), v.end());
	int x = 1; 
	for (int i = 0; i < 9; i++) {
		if (i != 0 && v[i].first != v[i - 1].first) x++;
		ord[v[i].second] = x;
	}
	for (int i = 1; i <= 9; i++) cout << ord[i] << "\n";
}