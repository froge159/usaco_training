import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class mad {
   public static void main(String[] args) throws IOException {
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // PrintWriter pw = new PrintWriter(System.out);
      
      BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
      PrintWriter pw = new PrintWriter(new FileWriter("breedflip.out"));
      
      int n = Integer.parseInt(br.readLine());
      char[] a = new char[n];
      char[] b = new char[n];
      int count = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      String myString = st.nextToken();
      for (int i = 0; i < n; i++) {
         a[i] = myString.charAt(i);
      }
      st = new StringTokenizer(br.readLine());
      myString = st.nextToken();
      for (int i = 0; i < n; i++) {
         b[i] = myString.charAt(i);
      }
      boolean x = false;
      for (int i = 0; i < n; i++) {
         if (a[i] != b[i]) {
            b[i] = a[i]; x = true;
         }
         else if (a[i] == b[i] && x) {
            count++; x = false;
         }
      }
      
      pw.println(count);
      pw.close();
   }
}
