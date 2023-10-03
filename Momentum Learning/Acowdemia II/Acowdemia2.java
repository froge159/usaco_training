import java.util.*;
import java.io.*;

public class Acowdemia2 {
   public static void main(String[] args) throws IOException {
      // BufferedReader br = new BufferedReader(new FileReader("input.in"));
      // PrintWriter pw = new PrintWriter("output.out");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken()); // number of publications
      int N = Integer.parseInt(st.nextToken()); // numbef of unique cows
      HashMap<String, Integer> order = new HashMap<>();
      String[] oArr = new String[N]; // expected order
      String[][] ans = new String[N][N]; // result array
      String[][] cows = new String[K][N]; // publications 
      

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         String x = st.nextToken();
         order.put(x, i);
         oArr[i] = x;
         Arrays.fill(ans[i], "?");
         ans[i][i] = "B";
      }
      for (int i = 0; i < K; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            cows[i][j] = st.nextToken();
         }	
      }

      for (int i = 0; i < K; i++) {
         for (int j = 0; j < N - 1; j++) {
            if (cows[i][j].compareTo(cows[i][j + 1]) > 0) {
               for (int z = 0; z < N; z++) {
                  if (z < j + 1) {
                     for (int x = j + 1; x < N; x++) {
                        ans[order.get(cows[i][z])][order.get(cows[i][x])] = "0";
                     }
                  }
                  else if (z > j) {
                     for (int x = j; x >= 0; x--) {
                        ans[order.get(cows[i][z])][order.get(cows[i][x])] = "1";
                     }
                  }
               }
            }
         }
      }
      for (String[] x: ans) {
         for (String j: x) {
            pw.print(j);
         }
         pw.println();
      }
      pw.close();
   }
}
