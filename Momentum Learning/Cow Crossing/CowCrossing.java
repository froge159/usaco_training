import java.util.*;
import java.io.*;

public class CowCrossing {  
   public static void main(String[] args) throws IOException {
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //PrintWriter pw = new PrintWriter(System.out);
      BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
      PrintWriter pw = new PrintWriter("crossroad.out");
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[][] arr = new int[N + 1][2];
      int count = 0;
      for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (arr[a][0] == 0)  {
                  arr[a][0] = a;
                  arr[a][1] = b;
                  continue;
            }
            if (arr[a][1] != b) {
                  count++;
                  arr[a][1] = b;
            }
      }
      pw.println(count);
      pw.close();
   }
}
