#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string my_string, string target) {
    int ms = my_string.size(), ts = target.size();
    if(ts > ms) return 0;
    for(int i = 0; i < ms - ts + 1; i++)
        if(my_string.substr(i, ts) == target) return 1;   
    return 0;
}