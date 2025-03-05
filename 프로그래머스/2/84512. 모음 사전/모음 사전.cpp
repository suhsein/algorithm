#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string word) {
    string s = "AEIOU";
    int arr[] = { 781, 156, 31, 6, 1 }, answer = 0;
    
    for(int i = 0; i < word.size(); i++)
        answer += s.find(word[i]) * arr[i] + 1; 
    
    return answer;
}