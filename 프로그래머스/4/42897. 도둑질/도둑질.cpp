#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int dp[1000006];
int solution(vector<int> money) {
    int ans = 0, n = money.size();
    // 0 방문 n - 1 x
    dp[0] = money[0];
    dp[1] = max(money[0], money[1]);
    
    for(int i = 2; i < n - 1; i++)
        dp[i] = max(dp[i-1], dp[i-2] + money[i]);
    
    ans = dp[n-2];
    
    // n - 1 방문 0 x
    fill(dp, dp + n, 0);
    dp[1] = money[1];
    
    for(int i = 2; i < n; i++)
        dp[i] = max(dp[i-1], dp[i-2] + money[i]);
   
    ans = max(ans, dp[n-1]);
    
    return ans;
}