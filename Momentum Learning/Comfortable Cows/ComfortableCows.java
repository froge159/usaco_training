import java.util.*;
import java.io.*;

public class ComfortableCows {
   static int comfortable(int x, int y, boolean[][] pl) {
      int c = 0;
      try{   if (pl[y][x]) {
            try {if (pl[y][x + 1]) c++;} catch (Exception e) {c += 0;}
            try {if (pl[y][x - 1]) c++;} catch (Exception e) {c += 0;}
            try {if (pl[y + 1][x]) c++;} catch (Exception e) {c += 0;}
            try {if (pl[y - 1][x]) c++;} catch (Exception e) {c += 0;}
         }
      }
      catch (Exception e) {return 0;}
      if (c == 3) return 1;
      else return 0;
   }
   public static void main(String[] args) throws IOException {
      // BufferedReader br = new BufferedReader(new FileReader("input.in"));
      // PrintWriter pw = new PrintWriter("output.out");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      boolean[][] pl = new boolean[1001][1001];
      int total = 0;
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         int original = comfortable(x + 1, y, pl);
         original += comfortable(x - 1, y, pl);
         original += comfortable(x, y + 1, pl);
         original += comfortable(x, y - 1, pl);
         pl[y][x] = true;
         int newCount = comfortable(x + 1, y, pl);
         newCount += comfortable(x - 1, y, pl);
         newCount += comfortable(x, y + 1, pl);
         newCount += comfortable(x, y - 1, pl);
         total -= (original - newCount);
         total += comfortable(x, y, pl);
         pw.println(total);
         
      }
      pw.close();

   }
}
