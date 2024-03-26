#include <iostream>
#include <vector>
using namespace std;
int N;
vector<int> v;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N / 2; i++) {
		v.push_back(1);
		v.push_back(2);
	}
	if (N % 2) v.push_back(3);
	for (auto x : v) cout << x << " ";
}