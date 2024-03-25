#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers, int n) {
    int answer = 0;
    for(auto x : numbers){
        answer += x;
        if(answer > n) return answer;
    }
    return answer;
}