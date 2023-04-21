import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter("billboard.out");
        ArrayList<Integer> b1 = new ArrayList<Integer>();
        ArrayList<Integer> b2 = new ArrayList<Integer>();
        ArrayList<Integer> truck = new ArrayList<Integer>();
        int covered = 0;
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            b1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            b2.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        // variables
        int bl_1_x = b1.get(0), bl_1_y = b1.get(1), tr_1_x = b1.get(2), tr_1_y = b1.get(3);
        int bl_2_x = b2.get(0), bl_2_y = b2.get(1), tr_2_x = b2.get(2), tr_2_y = b2.get(3);
        int bl_t_x = truck.get(0), bl_t_y = truck.get(1), tr_t_x = truck.get(2), tr_t_y = truck.get(3);

        //area
        int b1_area = (tr_1_y - bl_1_y) * (tr_1_x - bl_1_x);
        int b2_area = (tr_2_y - bl_2_y) * (tr_2_x - bl_2_x);
        int total_area = (b1_area + b2_area);

        // covered area
        if (!(bl_1_x >= tr_t_x || tr_1_x <= bl_t_x || bl_1_y >= tr_t_y || tr_1_y <= bl_t_y)){
            covered += ((Math.min(tr_1_x, tr_t_x) - Math.max(bl_1_x, bl_t_x)) * (Math.min(tr_1_y, tr_t_y) - Math.max(bl_1_y, bl_t_y)));
        }        
        if (!(bl_2_x >= tr_t_x || tr_2_x <= bl_t_x || bl_2_y >= tr_t_y || tr_2_y <= bl_t_y)){
            covered += ((Math.min(tr_2_x, tr_t_x) - Math.max(bl_2_x, bl_t_x)) * (Math.min(tr_2_y, tr_t_y) - Math.max(bl_2_y, bl_t_y)));
        }
        pw.println(total_area - covered);
        pw.close();

    }
}
