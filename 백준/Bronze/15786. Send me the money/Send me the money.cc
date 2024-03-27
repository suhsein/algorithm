#include <iostream>
#include <string>
using namespace std;
int N, M, cnt;
string origin, post;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N >> M >> origin;
	while (M--) {
		cin >> post;
		int idx = 0;
		for (int i = 0; i < post.size(); i++) {
			if (post[i] == origin[idx]) idx++;
			if (idx == N) break;
		}
		cout << ((idx == N) ? "true\n" : "false\n");
	}
}