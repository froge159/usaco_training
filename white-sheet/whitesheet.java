import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> white = new ArrayList<Integer>();
        ArrayList<Integer> black1 = new ArrayList<Integer>();
        ArrayList<Integer> black2 = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            white.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            black1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            black2.add(Integer.parseInt(st.nextToken()));
        }
        //bl_w_x, bl_w_y, tr_w_x, tr_w_y
        int bl_w_x = white.get(0), bl_w_y = white.get(1), tr_w_x = white.get(2), tr_w_y = white.get(3);
        int bl_b1_x = black1.get(0), bl_b1_y = black1.get(1), tr_b1_x = black1.get(2), tr_b1_y = black1.get(3);
        int bl_b2_x = black2.get(0), bl_b2_y = black2.get(1), tr_b2_x = black2.get(2), tr_b2_y = black2.get(3);

        int whiteArea = (tr_w_y - bl_w_y) * (tr_w_x - bl_w_x);
        int whiteb1Area = 0;
        int whiteb2Area = 0;
        int b1b2Area = 0;

        if (!(bl_w_x >= tr_b1_x || tr_w_x <= bl_b1_x || bl_w_y >= tr_b1_y || tr_w_y <= bl_b1_y)) {
            whiteb1Area = (Math.min(tr_w_x, tr_b1_x) - Math.max(bl_w_x, bl_b1_x)) * (Math.min(tr_w_y, tr_b1_y) - Math.max(bl_w_y, bl_b1_y));
        }
        if (!(bl_w_x >= tr_b2_x || tr_w_x <= bl_b2_x || bl_w_y >= tr_b2_y || tr_w_y <= bl_b2_y)) {
            whiteb2Area = (Math.min(tr_w_x, tr_b2_x) - Math.max(bl_w_x, bl_b2_x)) * (Math.min(tr_w_y, tr_b2_y) - Math.max(bl_w_y, bl_b2_y));
        }
        if (!(bl_b1_x >= tr_b2_x || tr_b1_x <= bl_b2_x || bl_b1_y >= tr_b2_y || tr_b1_y <= bl_b2_y)) {
            b1b2Area = (Math.min(tr_b1_x, tr_b2_x) - Math.max(bl_b1_x, bl_b2_x)) * (Math.min(tr_b1_y, tr_b2_y) - Math.max(bl_b1_y, bl_b2_y));
        }

        int openArea = whiteArea - whiteb1Area - whiteb2Area + b1b2Area;
		if (whiteArea == whiteb1Area || whiteArea == whiteb2Area) {
			openArea = 0;
		}
        if (openArea > 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        
    }
}
