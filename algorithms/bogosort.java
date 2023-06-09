import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class bogosort {
   static ArrayList<Integer> arr = new ArrayList<Integer>();
   static int n;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);

      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         arr.add(Integer.parseInt(st.nextToken()));
      }

      while(!(arr.stream().sorted().collect(Collectors.toList()).equals(arr))) {
         Collections.shuffle(arr);
      }

      pw.println(arr.toString());
      pw.close();


   }
}
