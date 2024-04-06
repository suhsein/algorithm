#include <iostream>
using namespace std;
int N;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> N;
	if (N < 425) cout << "Violet";
	else if (N < 450) cout << "Indigo";
	else if (N < 495) cout << "Blue";
	else if (N < 570) cout << "Green";
	else if (N < 590) cout << "Yellow";
	else if (N < 620) cout << "Orange";
	else if (N <= 780) cout << "Red";
}