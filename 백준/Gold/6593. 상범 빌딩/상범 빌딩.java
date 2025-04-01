import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedWriter bw;
    static int L, R, C;
    static char[][][] map;
    static int[][][] dist;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static Tuple start;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String str;
        
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            dist = new int[L][R][C];
            ans = -1;
            
            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    str = br.readLine();
                    char[] tmp = str.toCharArray();
                    for(int k = 0; k < C; k++){
                        if(tmp[k] == 'S') start = new Tuple(i, j, k);
                        map[i][j][k] = tmp[k];
                        dist[i][j][k] = -1;
                    }
                } 
                str = br.readLine();
            }

            bfs();
            if(ans != -1) bw.write("Escaped in " + Integer.toString(ans) + " minute(s).\n");
            else bw.write("Trapped!\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<Tuple> q = new LinkedList<>();
        q.add(start);
        dist[start.x][start.y][start.z] = 0;

        while(!q.isEmpty()){
            Tuple cur = q.poll();
            
            for(int d = 0; d < 6; d++){
                int nx = cur.x + dx[d], ny = cur.y + dy[d], nz = cur.z + dz[d];
                if(nx < 0 || ny < 0 || nz < 0 || nx >= L || ny >= R || nz >= C) continue;
                if(dist[nx][ny][nz] != -1|| map[nx][ny][nz] == '#') continue;
                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
                if(map[nx][ny][nz] == 'E') {
                    ans = dist[nx][ny][nz];
                    return;
                }
                q.add(new Tuple(nx, ny, nz));
            }
        }
    }
    
    public static class Tuple {
        int x, y, z;

        public Tuple(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}