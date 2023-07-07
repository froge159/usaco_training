import java.util.*;
import java.io.*;

public class sleepy {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
      PrintWriter pw = new PrintWriter("sleepy.out");
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      int count = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {arr[i] = Integer.parseInt(st.nextToken());}

      for (int i = n - 1; i > 0; i--) {
         if (arr[i] > arr[i - 1]) {count++;}
         else {break;}
      }
      pw.println(n - (count + 1));
      pw.close();
   }
}
