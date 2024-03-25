#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int a, int b) {
    string as = to_string(a), bs = to_string(b);
    int answer = max(stoi(as+bs), stoi(bs+as));
    return answer;
}