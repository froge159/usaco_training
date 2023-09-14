import java.util.*;
import java.io.*;

public class CircleUnion {
   static ArrayList<Integer> ypoints = new ArrayList<>();
   static ArrayList<Integer> xpoints = new ArrayList<>();

   static void check(int a, int b, int x, int y, int r) {
      boolean found = false;
      if (Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2)) > r) {
         //System.out.println(a + " " + b + " " + x);
         found = true;
      }
      for (int i = 0; i < xpoints.size(); i++) {
         if (xpoints.get(i) == a && ypoints.get(i) == b) {
            found = true;  break;
         }
      }
      if (!found) {
         xpoints.add(a);
         ypoints.add(b);
      }
      //System.out.println(xpoints.toString());
      //System.out.println(ypoints.toString());
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());// 0,1    1,0   0, -1   -1, 0
         int y = Integer.parseInt(st.nextToken());
         int r = Integer.parseInt(st.nextToken());
         check(x, y, x, y, r);
         for (int xpt = x; xpt <= x + r; xpt++) {
            for (int ypt = y; ypt <= y + r; ypt++) {
               check(x + xpt, y + ypt, x, y, r);
               check(x + xpt, y - ypt, x, y, r);
               check(x - xpt, y + ypt, x, y, r);
               check(x - xpt, y - ypt, x, y, r);
            }
         }
         //System.out.println(xpoints.toString());
         //System.out.println(ypoints.toString());

      }
      System.out.println(xpoints.toString());
      System.out.println(ypoints.toString());
   }
}
