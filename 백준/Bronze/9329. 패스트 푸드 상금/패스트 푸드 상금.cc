#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int t, n, m, k, money, ans;
vector<pair<int, vector<int>>> v;
vector<int> sticker(32);

bool cmp(pair<int, vector<int>>& a, pair<int, vector<int>>& b) {
	if (a.first == b.first) return a.second.size() < b.second.size();
	return a.first > b.first;
}
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> t;

	while (t--) {
		cin >> n >> m;
		fill(sticker.begin(), sticker.begin() + m + 1, 0);
		ans = 0;
		for (int i = 0; i < n; i++) {
			cin >> k;
			vector<int> tmp(k, 0);
			for (int j = 0; j < k; j++) cin >> tmp[j];
			cin >> money;
			v.push_back({ money, tmp });
		}
		for (int i = 1; i <= m; i++) cin >> sticker[i];
		sort(v.begin(), v.end(), cmp);
		for (int i = 0; i < n; i++) {
			while (1) {
				bool flag = 1;
				for (auto s : v[i].second) {
					if (sticker[s] == 0) {
						flag = 0;
						break;
					}
				}
				if (!flag) break;
				for (auto s : v[i].second) sticker[s]--;
				ans += v[i].first;
			}
		}
		cout << ans << "\n";
		v.clear();
	}
}