import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N, M, x, y, K;
    static int[] dice = new int[7];
    static int[] dice2 = new int[7];
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) 
                map[i][j] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int x = turn(dir);
            if(x != -1) bw.write(Integer.toString(x) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean OOB(int nx, int ny){
        return nx < 0 || ny < 0 || nx >= N || ny >= M;
    }
    
    
    public static int turn(int dir){
        int nx = x, ny = y;
        int ret = 0;
        
        if(dir == 1){
            ny = y + 1;
            if(OOB(nx, ny)) return -1;
            for(int i = 1; i <= 6; i++) dice2[i] = dice[i];
            dice[1] = dice2[4]; dice[2] = dice2[2]; dice[3] = dice2[1];
            dice[4] = dice2[6]; dice[5] = dice2[5]; dice[6] = dice2[3];
        } else if(dir == 2){
            ny = y - 1;
            if(OOB(nx, ny)) return -1;
            for(int i = 1; i <= 6; i++) dice2[i] = dice[i];
            dice[1] = dice2[3]; dice[2] = dice2[2]; dice[3] = dice2[6];
            dice[4] = dice2[1]; dice[5] = dice2[5]; dice[6] = dice2[4];
        } else if(dir == 3){
            nx = x - 1;
            if(OOB(nx, ny)) return -1;
            for(int i = 1; i <= 6; i++) dice2[i] = dice[i];
            dice[1] = dice2[5]; dice[2] = dice2[1]; dice[3] = dice2[3];
            dice[4] = dice2[4]; dice[5] = dice2[6]; dice[6] = dice2[2];
        } else if(dir == 4){
            nx = x + 1;
            if(OOB(nx, ny)) return -1;
            for(int i = 1; i <= 6; i++) dice2[i] = dice[i];
            dice[1] = dice2[2]; dice[2] = dice2[6]; dice[3] = dice2[3];
            dice[4] = dice2[4]; dice[5] = dice2[1]; dice[6] = dice2[5];
        }

        x = nx; y = ny;

        if(map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        return dice[1];
    }
}