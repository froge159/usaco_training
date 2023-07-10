import java.util.*;
import java.io.*;

public class taming {
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("taming.in"));
      PrintWriter pw = new PrintWriter("taming.out");
      int n = Integer.parseInt(br.readLine());
      int[] rec = new int[n];
      int min = 0; int max = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         rec[i] = Integer.parseInt(st.nextToken());
      }
      if (rec[0] > 0) {pw.println(-1); pw.close(); System.exit(0);}
      rec[0] = 0;

      for (int i = 0; i < n; i++) {
         if (rec[i] == 0) {min++;}
         else if (rec[i] > 0) {
            try {
               for (int j = i-1; j >= (i - rec[i]); j--) {
                  if (j == i - rec[i] && rec[j] == -1) {
                     int element = rec[i - rec[i]];
                     if (element == -1) {
                        min++;
                        rec[i - rec[i]] = 0; 
                        break;
                     }
                  }
                  else if (rec[j] == -1) {
                     rec[j] = rec[j + 1] - 1;
                  }
                  else if (rec[j] != rec[j + 1] - 1) {
                     pw.println(-1); pw.close();
                     System.exit(0);
                  }
               }
            }
            catch (Exception e) {
               pw.println(-1); pw.close();
               System.exit(0);
            }
         }
      }

   
      max += min;
      for (int i =  0; i < n; i++) {
         if (rec[i] == -1) {max++;}
      }
      pw.print(min); pw.println(" " + max);
      pw.close();
   }
}
