import java.util.*;
import java.io.*;

public class CircleUnion {
   static ArrayList<Integer> pointsx = new ArrayList<>();
   static ArrayList<Integer> pointsy = new ArrayList<>();
   static boolean check(int[] pts) {
      for (int i = 0; i < pointsx.size(); i++) {
         if (pointsx.get(i) == pts[0] && pointsy.get(i) == pts[1])  {
            //System.out.println("found");
            return true;
         }
      }
      return false;
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
         if (Math.sqrt((double) r) % 1 != 0) {
            continue;
         }
         for (int j = -r; j <= r; j+=2) {
            int[] pts1 = {x, y + j};
            int[] pts2 = {x + j, y};
            if (!check(pts1)) {
               pointsx.add(pts1[0]);
               pointsy.add(pts1[1]);
            }
            if (!check(pts2)) {
               pointsx.add(pts2[0]);
               pointsy.add(pts2[1]);
            }
            
         }

      }
      System.out.println(pointsx.size());
   }
}
