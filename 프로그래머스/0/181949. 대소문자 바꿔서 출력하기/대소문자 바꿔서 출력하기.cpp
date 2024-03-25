#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    int diff = 'a' - 'A';
    cin >> str;
    for(auto c: str)
        cout << ((c >= 'A' && c <= 'Z') ? char(c+diff) : char(c-diff));
    return 0;
}