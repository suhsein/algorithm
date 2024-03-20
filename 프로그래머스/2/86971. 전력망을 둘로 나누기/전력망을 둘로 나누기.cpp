#include <string>
#include <vector>
#include <stack>
#include <math.h>

using namespace std;

vector<bool> v, vw;
vector<vector<int>> w;
int sz;

int dfs(){
    stack<int> st;
    st.push(1);
    v[1] = 1;
    
    while(!st.empty()){
        int x = st.top(); st.pop();
        for(int i = 0; i < sz - 1; i++){
            if(vw[i]) continue;
            int a = w[i][0], b = w[i][1];
            if(!v[a] && v[b]){
                vw[i] = v[a] = 1;
                st.push(a);
                break;
            } 
            if(v[a] && !v[b]){
                vw[i] = v[b] = 1;
                st.push(b);
                break;
            }
        }   
    }
    int cnt = 0;
    for(int i = 1; i <= sz; i++) if(v[i]) cnt++;
    return cnt;
}

int solution(int n, vector<vector<int>> wires) {
    int ans = n;
    w = wires;
    sz = n;
    
    vw.resize(n, 0); v.resize(n + 1, 0);
    
    for(int i = 0; i < n - 1; i++){
        fill(v.begin(), v.end(), 0); fill(vw.begin(), vw.end(), 0);
        vw[i] = 1;
        int tmp = abs(n - 2 * dfs());
        if(ans > tmp) ans = tmp;
    }
    return ans;
}