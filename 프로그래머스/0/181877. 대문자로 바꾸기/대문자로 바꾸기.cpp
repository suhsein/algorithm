#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    for(auto& c : myString)
        if(c >= 'a' && c <= 'z') c -= ('a' - 'A');
    return myString;
}