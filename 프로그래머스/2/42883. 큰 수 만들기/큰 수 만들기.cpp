#include <string>
#include <vector>
#include <iostream>

using namespace std;


string solution(string number, int k) {
    int cnt = 0;
    
    while(cnt < k){
        for(int i = 0; i < number.size(); i++){
            if(i == number.size() - 1 || number[i] < number[i + 1]) {
                number.erase(i, 1);
                cnt++;
                break;
            }
        }  
    }
   
    return number;
}