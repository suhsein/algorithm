#include <string>
#include <vector>
#include <iostream>
#define MX 505


using namespace std;

int dp[MX][MX];

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    int n = triangle.size();
    for(int i = 0; i < n; i++){
        for(int j = 0; j <= i; j++){
            dp[i][j] = triangle[i][j];
            if(i == 0 && j == 0) continue;
            if(j >= 1) dp[i][j] += max(dp[i-1][j], dp[i-1][j-1]);
            else dp[i][j] += dp[i-1][j];
        }
    }
    
    for(int i = 0; i< n; i++)
        for(int j =0; j <= i ;j++)
            if(dp[i][j] > answer) answer = dp[i][j];

    return answer;
}