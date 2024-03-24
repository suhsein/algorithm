#include <string>
#include <vector>
#include <iostream>

using namespace std;

int arr[105][105];

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    for(auto r: results){
        arr[r[0]][r[1]] = 1;
        arr[r[1]][r[0]] = -1;
    }
    
    for(int j = 1; j <= n; j++){
        for(int i = 1; i <= n; i++){
            for(int k = 1; k <= n; k++){
                if(arr[i][j] == 1 && arr[j][k] == 1){
                    arr[i][k] = 1;
                    arr[k][i] = -1;
                }
            }
        }
    }
    
    for(int i = 1; i <= n; i++){
        int tmp = 0;
        for(int j = 1; j<= n; j++) if(!arr[i][j]) tmp++;
        if(tmp == 1) answer++;
    }
    return answer;
}