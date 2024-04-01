#include <iostream>
#define ll long long
using namespace std;
ll N, f = 1, num = 2, sum = 2;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	if (N <= 3) {
		if (!N) cout << "NO";
		else cout << "YES";
		return 0;
	}
	while (f * num <= N) {
		f *= num++;
		sum += f;
	}
	if (N > sum) cout << "NO";
	else cout << "YES";
}