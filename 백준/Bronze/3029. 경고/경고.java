import java.util.*;
import java.io.*;

public class Main{
    static String cur, time;
    static BufferedReader br;
    static int ch, cm, cs, th, tm, ts, rh, rm, rs; 
    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        init();
        
        if(cs <= ts) rs = ts - cs;
        else {
            rs = ts - cs + 60;
            tm--;
        }
        if(cm <= tm) rm = tm - cm;
        else {
            rm = tm - cm + 60;
            th--;
        }
        
        rh = th - ch;
        if(rh < 0) rh += 24;
       
        if(rh == 0 && rm == 0 && rs == 0) {
            System.out.println("24:00:00");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        if(rh == 0) sb.append("00");
        else {
            if(rh / 10 == 0) sb.append("0");
            sb.append(Integer.toString(rh));   
        }
        sb.append(":");
        if(rm == 0) sb.append("00");
        else {
            if(rm / 10 == 0) sb.append("0");
            sb.append(Integer.toString(rm));  
        }
        sb.append(":");
        if(rs == 0) sb.append("00");
        else {
            if(rs / 10 == 0) sb.append("0");
            sb.append(Integer.toString(rs));  
        }
        System.out.println(sb.toString());
    }
    
    public static void init() throws IOException{ 
        cur = br.readLine();
        time = br.readLine();

        StringTokenizer st = new StringTokenizer(cur, ":");
        ch = Integer.parseInt(st.nextToken());
        cm = Integer.parseInt(st.nextToken());
        cs = Integer.parseInt(st.nextToken());
        
        
        st = new StringTokenizer(time, ":");
        th = Integer.parseInt(st.nextToken());
        tm = Integer.parseInt(st.nextToken());
        ts = Integer.parseInt(st.nextToken());
        
        rh = 0;
        rm = 0;
        rs = 0;
    }
}