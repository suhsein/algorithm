import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[][] arr = new int[4][4]; 
    static Fish[] fishes = new Fish[17];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int num, dir;
        
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < 4; j++) {
                num = Integer.parseInt(st.nextToken());    
                dir = Integer.parseInt(st.nextToken()) - 1;

                arr[i][j] = num;
                fishes[num] = new Fish(i, j, dir);
            }
        }

        int target = arr[0][0];
        int d = fishes[target].dir;
        fishes[target].isDead = true;
        arr[0][0] = -1;

        moveShark(0, 0, d, target);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    public static void moveShark(int x, int y, int d, int acc) {
        if(acc > ans) ans = acc;
            
        int[][] tmpArr = new int[4][4];
        for(int i = 0; i < 4; i++) 
            System.arraycopy(arr[i], 0, tmpArr[i], 0, 4);  

        Fish[] tmpFishes = new Fish[17];
        for(int i = 1; i <= 16; i++) 
            tmpFishes[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].dir, fishes[i].isDead);

        moveFish();

        for(int i = 1; i < 4; i++){
            int nx = x + dx[d] * i;
            int ny = y + dy[d] * i;

            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && arr[nx][ny] != 0) {
                int target = arr[nx][ny];
                int nd = fishes[target].dir;
                
                arr[x][y] = 0;
                arr[nx][ny] = -1;
                fishes[target].isDead = true;

                moveShark(nx, ny, nd, acc + target);

                arr[x][y] = -1;
                arr[nx][ny] = target;
                fishes[target].isDead = false;
            }
        }

        for(int i = 0; i < 4; i++) 
            System.arraycopy(tmpArr[i], 0, arr[i], 0, 4);  

        for(int i = 1; i <= 16; i++) 
            fishes[i] = new Fish(tmpFishes[i].x, tmpFishes[i].y, tmpFishes[i].dir, tmpFishes[i].isDead);
    }

    public static void moveFish() {
        for(int i = 1; i <= 16; i++) {
            if (fishes[i].isDead) continue;
            int dir = fishes[i].dir;
            int nx = fishes[i].x + dx[dir], ny = fishes[i].y + dy[dir];
            boolean dontMove = false;
            
            while (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || arr[nx][ny] == -1) {
                dir = (dir + 1) % 8;
                if(dir == fishes[i].dir) {
                    dontMove = true;
                    break;
                }
                nx = fishes[i].x + dx[dir]; ny = fishes[i].y + dy[dir];  
            } 
            if(dontMove) continue;

            if(arr[nx][ny] == 0) arr[fishes[i].x][fishes[i].y] = 0;
            else {
                int target = arr[nx][ny];
                arr[fishes[i].x][fishes[i].y] = target;
                fishes[target].x = fishes[i].x;
                fishes[target].y = fishes[i].y;
            }
            arr[nx][ny] = i;
            fishes[i].x = nx;
            fishes[i].y = ny;
            fishes[i].dir = dir;
        }
    }
    
    public static class Fish {
        public int x;
        public int y;
        public int dir;
        public boolean isDead;

        public Fish(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isDead = false;
        }

        public Fish(int x, int y, int dir, boolean isDead) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isDead = isDead;
        }
    }
}
