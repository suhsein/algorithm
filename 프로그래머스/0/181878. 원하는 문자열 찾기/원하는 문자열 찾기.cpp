#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int ms = myString.size(), ps = pat.size(), diff = ('a' - 'A');
    if(ps > ms) return 0;
    for(auto &m : myString) if(m <= 'Z') m += diff;
    for(auto &p : pat) if(p <= 'Z') p += diff;
    for(int i = 0; i < ms - ps + 1; i++) if (myString.substr(i, ps) == pat) return 1;
    return 0;
}