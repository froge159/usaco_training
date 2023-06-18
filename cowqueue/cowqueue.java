import java.util.*;
import java.io.*;

public class cowqueue {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
      PrintWriter pw = new PrintWriter("cowqueue.out");
      int n = Integer.parseInt(br.readLine());
      int[] start = new int[n]; int[] time = new int[n];
      for (int i = 0; i < n; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         start[i] = Integer.parseInt(st.nextToken()); time[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n - 1; j++) {
            if (start[j] > start[j + 1]) {
               int temp = start[j];
               start[j] = start[j + 1]; start[j + 1] = temp;
               int temp2 = time[j];
               time[j] = time[j + 1]; time[j + 1] = temp2;
            }
         }
      }
      // 2 1
      // 5 7
      // 8 3
      int curr = start[0] + time[0];
      for (int i = 0; i < n-1; i++) {
         if (curr > start[i + 1]) {
            curr += time[i + 1];
         }
         else{
            curr = start[i + 1];
            curr += time[i + 1];
         }
      }
      pw.println(curr);
      pw.close();
   }
}
