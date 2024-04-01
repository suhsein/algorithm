#include <iostream>
#include <string>
#define MX 1000005
using namespace std;
int N, U, D;
string ans;
int arr[MX];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		ans += "U";
	}
	cin >> U >> D;

	for (int i = 0; i < N; i++) {
		if (arr[i] == 1) {
			if (U) U--;
		}
		else if (arr[i] == 2) {
			if (D) {
				D--;
				ans[i] = 'D';
			}
		}
	}
	for (int i = 0; i < N; i++) {
		if (arr[i] == 3) {
			if (U) U--;
			else if (D) {
				D--;
				ans[i] = 'D';
			}
		}
	}

	if (U || D) cout << "NO";
	else cout << "YES\n" << ans;
	
}