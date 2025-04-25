class Solution {
    static int[] answer = {0,0};
    static int[][] arr;
    static int[] discount = {10,20,30,40};
    public int[] solution(int[][] users, int[] emoticons) {
        int n = emoticons.length;
        arr = new int[n][2]; // 0 = 할인율, 1 = 가격
        
        solve(0, n, users, emoticons);
        return answer;
    }
    
    public static void solve(int cnt, int n, int[][] users, int[] emoticons) {
        if(cnt == n) {
            int eplus = 0, total = 0;
            for(int i = 0; i < users.length; i++) {
                int acc = 0;
                for(int j = 0; j < arr.length; j++) {
                    if(users[i][0] > arr[j][0]) continue;
                    acc += arr[j][1];
                }
                if(acc >= users[i][1]) eplus++;
                else total += acc;
            }
            
            if(eplus > answer[0] || eplus == answer[0] && total > answer[1]) {
                answer[0] = eplus;
                answer[1] = total;
            }
            return;
        }
        
        for(int j = 0; j < 4; j++) {
            arr[cnt][0] = discount[j];
            arr[cnt][1] = emoticons[cnt] * (100 - discount[j]) / 100;
            solve(cnt + 1, n, users, emoticons);
        }
    }
}