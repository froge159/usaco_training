import java.util.*;
import java.io.*;

public class distinctNumbers {
   static int n;
   static HashSet<Integer> list = new HashSet<Integer>();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         list.add(Integer.parseInt(st.nextToken()));
      }

      pw.println(list.size());
      pw.close();
   }
}
