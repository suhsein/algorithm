#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string my_string, string alp) {
    for(auto &c: my_string) if(c == alp[0]) c -= ('a'-'A');   
    return my_string;
}