#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string name) {
    int ans = 0, n = name.size(), shft = n - 1;
    
    for(int i = 0; i < n; i++) {
        if(name[i] == 'A'){
            int tmp = i;
            while(tmp < n && name[tmp] == 'A') tmp++;
            
            int l = (i == 0) ? 0 : i - 1;
            int r = n - tmp;
            
            shft = min(shft, l + r + min(l,r));
        }
    }
    ans += shft;
    for(auto c: name) ans += min(c - 'A', 'Z' - c + 1);
    return ans;
}