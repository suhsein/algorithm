#include <iostream>
#include <string>
using namespace std;
string A, B;
int mn, mx;
int main(void) {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> A >> B;
	for (auto& a : A) if (a == '5') a = '6';
	for (auto& b : B) if (b == '5') b = '6';
	mx = stoi(A) + stoi(B);
	for (auto& a : A) if (a == '6') a = '5';
	for (auto& b : B) if (b == '6') b = '5';
	mn = stoi(A) + stoi(B);
	cout << mn << " " << mx;
}