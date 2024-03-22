#include <string>
#include <vector>
#define MD 1000000007
#define MX 105
using namespace std;


int dp[MX][MX];
bool prevent[MX][MX];
int solution(int m, int n, vector<vector<int>> puddles) {
    for(auto p : puddles)
        prevent[p[0]][p[1]] = 1;
    
    dp[1][1] = 1;
    for(int i = 1; i <= m; i++){
        for(int j = 1; j <=n; j++){
            if(i == 1 && j == 1 || prevent[i][j]) continue;
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MD;
        }
    }
    
    return dp[m][n] % MD;
}