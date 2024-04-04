#include <iostream>
#include <vector>
#include <algorithm>
#define X first
#define Y second
#define MX 105
using namespace std;
int N, M, A, B, map[MX][MX], x, y, cnt, ans;
bool p[MX][MX];
vector<pair<int, int>> v;

void solve(int a, int b, int c, int d) {
	for (int i = a; i <= c; i++) {
		for (int j = b; j <= d; j++) {
			if (i == a && j == b) continue;
			if (p[i][j]) continue;
			if (!p[i - 1][j]) map[i][j] += map[i - 1][j];
			if (!p[i][j - 1]) map[i][j] += map[i][j - 1];
		}
	}
}

int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M >> A >> B;
	while (A--) {
		cin >> x >> y;
		v.push_back({ x - 1,y - 1 });
	}
	N--; M--;
	v.push_back({ 0,0 }); v.push_back({ N, M });
	
	while (B--) {
		cin >> x >> y;
		p[x - 1][y - 1] = 1;
	}

	sort(v.begin(), v.end());
	map[0][0] = 1;
	for (int i = 1; i < v.size(); i++) 
		solve(v[i - 1].X, v[i - 1].Y, v[i].X, v[i].Y);
	
	cout << map[N][M];
}