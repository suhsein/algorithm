import java.lang.Math;
import java.util.*;

class Solution {
    static int n;
    static int[][] dp;
    static List<Integer>[] team;
    
    public int solution(int[] sales, int[][] links) {
        dp = new int[sales.length + 1][2];
        n = sales.length;
        
        team = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) team[i] = new ArrayList<>();
        for(int i = 0; i < links.length; i++) {
            int u = links[i][0], v = links[i][1];
            team[u].add(v);
        }
        
        dfs(sales, 1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int[] sales, int node){
        dp[node][1] = sales[node - 1];
        if(team[node].isEmpty()) return;
        
        int mingap = Integer.MAX_VALUE, sum = 0;
        
        for(int member : team[node]) {
            dfs(sales, member);
            
            sum += Math.min(dp[member][0], dp[member][1]);
            mingap = Math.min(mingap, dp[member][1] - dp[member][0]);
        }
        
        // 현재 노드의 팀원들 각각에 대하여 참여하는 것과 참여하지 않는 것 중 더 적은 매출액 합을 구한다.
        
        // 1의 경우 : 현재 노드 참석 => 더 고려하지 않아도 됨.
        
        // 0의 경우 : 현재 노드 불참 => 팀원들 중 하나라도 참석해야함
        // mingap : 팀원들 중 참석했을 때 더해야 하는 매출액이 최소가 되는 경우
        // mingap 음수 : 팀원들이 모두 참여하는 것이 이득인 경우
        // => 애초에 참석이 이득이고, 팀원 모두 참여하므로 더할 필요 없음
        
        if(mingap < 0) mingap = 0;
        dp[node][1] += sum;
        dp[node][0] = sum + mingap;
    }
}