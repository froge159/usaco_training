import java.util.*;
import java.io.*;

public class whereAmI {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
      PrintWriter pw = new PrintWriter("whereami.out");
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      String road = st.nextToken();
      HashSet<String> mail = new HashSet<>();
      //  k == 2
      for (int i = 1; i <= n; i++) {
         String temp = "";
         for (int j = 0; j <= (n-i); j++) {
            temp = String.valueOf(road.charAt(j));
            for (int x = j + 1; x <= (j+(i-1)); x++) {
               temp += String.valueOf(road.charAt(x));
            }
            mail.add(temp);
         }
         if (mail.size() == n - i + 1) {pw.println(i); break;}
         mail.clear();
      }
      pw.close();
   }
}
