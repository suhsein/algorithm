#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string my_string, int n) {
    string answer = "";
    int idx = my_string.size() - 1;
    while(n--) answer += my_string[idx--];
    reverse(answer.begin(), answer.end());
    return answer;
}