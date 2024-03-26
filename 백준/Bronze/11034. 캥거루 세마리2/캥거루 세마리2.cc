#include <iostream>
#include <algorithm>
using namespace std;
int arr[3];
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	while (cin >> arr[0]) {
		cin >> arr[1] >> arr[2];
		int cnt = 0;
		while (1) {
			sort(arr, arr + 3);
			int gap1 = arr[1] - arr[0], gap2 = arr[2] - arr[1];
			if (gap1 >= gap2) {
				arr[2] = arr[1] - 1;
				if (arr[2] == arr[0]) break;
			}
			else {
				arr[0] = arr[2] - 1;
				if (arr[0] == arr[1]) break;
			}
			cnt++;
		}
		cout << cnt << "\n";
	}
}