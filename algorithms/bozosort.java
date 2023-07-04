import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class bozosort {
   public static void main(String[] args) throws IOException {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      int count = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
         arr.add(Integer.parseInt(st.nextToken()));
      }
      Random rand = new Random();
      while(!(arr.stream().sorted().collect(Collectors.toList()).equals(arr))) {
         int x = rand.nextInt(arr.size()); int y = rand.nextInt(arr.size());
         Collections.swap(arr, x, y);
         System.out.println(arr.toString());
         count++;
      }

      pw.println("Sorted " + arr.toString());
      pw.println(count + " swaps");
      pw.close();
   }
}
