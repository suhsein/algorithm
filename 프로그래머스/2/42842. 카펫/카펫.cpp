#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    for(int h = 1; h <= yellow / h; h++){
        if(yellow % h) continue;
        int bh = h + 2, bw = yellow / h + 2;
        if(bh * bw - yellow == brown){
            answer.push_back(bw);
            answer.push_back(bh);
            break;
        }
    }
    return answer;
}