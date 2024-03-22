#include <vector>
#include <string>
#include <algorithm>
#define MX 205
using namespace std;

int solution(vector<string> arr)
{   
    int dp[2], idx = arr.size() - 1, sum = 0;
    
    while(idx >= 0){
        if(arr[idx][0] >= '0'){
            sum += stoi(arr[idx]);
        } else if(arr[idx] == "-") {
            int tmp[2];
            tmp[0] = dp[0], tmp[1] = dp[1];
            dp[0] = max(sum + tmp[0] - 2 * (stoi(arr[idx+1])), -(sum + tmp[1]));
            dp[1] = min(-sum + tmp[1], -(sum + tmp[0]));
            sum = 0;
        }
        idx--;
    }
   
    return sum + dp[0];
}