import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Long> white = new ArrayList<Long>();
        ArrayList<Long> black1 = new ArrayList<Long>();
        ArrayList<Long> black2 = new ArrayList<Long>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            white.add(Long.parseLong(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            black1.add(Long.parseLong(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            black2.add(Long.parseLong(st.nextToken()));
        }
        //bl_w_x, bl_w_y, tr_w_x, tr_w_y
        long bl_w_x = white.get(0), bl_w_y = white.get(1), tr_w_x = white.get(2), tr_w_y = white.get(3);
        long bl_b1_x = black1.get(0), bl_b1_y = black1.get(1), tr_b1_x = black1.get(2), tr_b1_y = black1.get(3);
        long bl_b2_x = black2.get(0), bl_b2_y = black2.get(1), tr_b2_x = black2.get(2), tr_b2_y = black2.get(3);

        long whiteArea = (tr_w_y - bl_w_y) * (tr_w_x - bl_w_x);
        long whiteb1Area = 0;
        long whiteb2Area = 0;
        long b1b2Area = 0;

        if (!(bl_w_x >= tr_b1_x || tr_w_x <= bl_b1_x || bl_w_y >= tr_b1_y || tr_w_y <= bl_b1_y)) {
            whiteb1Area = (Math.min(tr_w_x, tr_b1_x) - Math.max(bl_w_x, bl_b1_x)) * (Math.min(tr_w_y, tr_b1_y) - Math.max(bl_w_y, bl_b1_y));
        }
        if (!(bl_w_x >= tr_b2_x || tr_w_x <= bl_b2_x || bl_w_y >= tr_b2_y || tr_w_y <= bl_b2_y)) {
            whiteb2Area = (Math.min(tr_w_x, tr_b2_x) - Math.max(bl_w_x, bl_b2_x)) * (Math.min(tr_w_y, tr_b2_y) - Math.max(bl_w_y, bl_b2_y));
        }
        if (!(bl_b1_x >= tr_b2_x || tr_b1_x <= bl_b2_x || bl_b1_y >= tr_b2_y || tr_b1_y <= bl_b2_y)) {
            b1b2Area = (Math.min(tr_b1_x, tr_b2_x) - Math.max(bl_b1_x, bl_b2_x)) * (Math.min(tr_b1_y, tr_b2_y) - Math.max(bl_b1_y, bl_b2_y));
        }

        long openArea = whiteArea - whiteb1Area - whiteb2Area + b1b2Area;
		if (whiteArea == whiteb1Area || whiteArea == whiteb2Area) { openArea = 0;}
        PrintWriter pw = new PrintWriter(System.out);
        if (openArea > 0) { pw.println("YES"); }
        else { pw.println("NO"); } 
        pw.close();
    }
}
