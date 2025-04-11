import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static List<List<Integer>> like;
    static int[][] map;
    static int[][] tmp;
    static int ans = 0; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        like = new ArrayList<>(N + 1);
        map = new int[N][N];

        for(int i = 0; i < N * N + 1; i++) like.add(new ArrayList<>());
        
        for(int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cur = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 4; j++){
                like.get(cur).add(Integer.parseInt(st.nextToken()));
            }
            adj(cur);
        }

        calc();
        
        br.close();
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }

    public static void calc(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int cur = map[i][j];
                int cnt = 0;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d], ny = j + dy[d];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if(like.get(cur).contains(map[nx][ny])) cnt++;
                }
                if(cnt == 1) ans += 1;
                else if(cnt == 2) ans += 10;
                else if(cnt == 3) ans += 100;
                else if(cnt == 4) ans += 1000;
            }
        }
    }

    public static void adj(int cur){
        List<List<Integer>> tmp = new ArrayList<>();
        int emptyCount, friendCount;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 0) continue;
                emptyCount = 0;
                friendCount = 0;
                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d], ny = j + dy[d];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int num = map[nx][ny];
                    if(like.get(cur).contains(num)) friendCount++;
                    if(map[nx][ny] == 0) emptyCount++;
                }
                tmp.add(List.of(friendCount, emptyCount, i, j));
            }
        }

        Collections.sort(tmp, (o1, o2) -> {
            if(o1.get(0) != o2.get(0)) return o2.get(0) - o1.get(0);
            if(o1.get(1) != o2.get(1)) return o2.get(1) - o1.get(1);
            if(o1.get(2) != o2.get(2)) return o1.get(2) - o2.get(2);
            return o1.get(3) - o2.get(3);
        });

        map[tmp.get(0).get(2)][tmp.get(0).get(3)] = cur;
    }
}