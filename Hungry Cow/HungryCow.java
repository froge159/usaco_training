import java.util.*;
import java.io.*;

public class HungryCow {
   public static void main(String[] args) throws IOException {
      //BufferedReader br = new BufferedReader(new FileReader("swap.in"));
      //PrintWriter pw = new PrintWriter("swap.out");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      long N = Long.parseLong(st.nextToken());
      long T = Long.parseLong(st.nextToken());
      long totalHay = 0;
      long count = 0;
      long prevDay = 0;
      for (long i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         long a =  Long.parseLong(st.nextToken());
         long b = Long.parseLong(st.nextToken());
          // totalHay =  1;      count = 1;      prevDay = 1
         if (a - 2 >= prevDay) {
            if (totalHay >= a - prevDay - 1) {
               count += a - prevDay - 1;
               totalHay -= a - prevDay - 1;
               totalHay += b;
               if (totalHay > 0) count++; totalHay--;
            }
            else {
               count += totalHay;
               totalHay = 0 + b;
               if (totalHay > 0) count++; totalHay--;
            }
            prevDay = a;
            continue;
         }
         totalHay += b;
         if (totalHay > 0) {
            totalHay--;
            count++;
            prevDay = a;
            continue;
         }
         else  {
            prevDay = a;
            continue;
         }

      }// 50-100     80
      if (prevDay < T) {
         if (T - prevDay < totalHay) {
            count += T - prevDay;
         }
         else {
            count += totalHay;
         }
      }
      pw.println(count);
      pw.close();
   }
}
