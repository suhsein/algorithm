#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> num_list) {
    string e = "", o = "";
    for(auto n : num_list){
        if(n % 2) e += (n + '0');
        else o += (n + '0');
    }
    return stoi(e) + stoi(o);    
}