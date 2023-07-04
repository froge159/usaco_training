import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class bogosort {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      ArrayList<Integer> arr = new ArrayList<Integer>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         arr.add(Integer.parseInt(st.nextToken()));
      }
      int count = 0;
      while(!(arr.stream().sorted().collect(Collectors.toList()).equals(arr))) {
         Collections.shuffle(arr); count++; pw.println(arr.toString());
      }
      pw.println();
      pw.println("Sorted " + arr.toString());
      pw.println(count + " randomizations");
      pw.close();


   }
}
