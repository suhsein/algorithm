#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n, ans;
vector<int> v;

void split_stick(vector<int> st) {
	int l = 0, r = st.size() - 1, sum = 0;
	for (auto x : st) sum += x;
	int target = sum / 2, tmp = 0;
	if (sum % 2) target++;

	while (1) {
		if (tmp + st[r] <= target) tmp += st[r--];
		else if (tmp + st[l] <= target) tmp += st[l++];
		else break;
	}

	ans += (tmp * (sum - tmp));
	vector<int> v1, v2;
	for (int i = 0; i < l; i++)  v1.push_back(st[i]);
	for (int i = r + 1; i < st.size(); i++) v1.push_back(st[i]);
	for (int i = l; i <= r; i++) v2.push_back(st[i]);
	if (v1.size() > 1) split_stick(v1);
	if (v2.size() > 1) split_stick(v2);
}

int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n;
	v.resize(n, 0);
	for (int i = 0; i < n; i++) cin >> v[i];
	sort(v.begin(), v.end());
	split_stick(v);

	cout << ans;
}