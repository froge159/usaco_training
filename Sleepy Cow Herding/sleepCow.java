import java.util.*;
import java.io.*;

public class sleepCow {
    public static int check(int index, ArrayList<Integer> list, int var) {
      if (list.get(index) == 2) {var = 1;}
      else if (list.get(index) > 2) {var = 2;}
      return var;
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("herding.in"));
      PrintWriter pw = new PrintWriter("herding.out");
      int[] arr = new int[3];
      int min = 0; int max = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 3; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);
      int[] ar = arr.clone();
      ArrayList<Integer> ranges = new ArrayList<>(); 
      ranges.add(arr[1]-arr[0]); 
      ranges.add(arr[2] - arr[1]);
      Collections.sort(ranges);
      if (ranges.get(0) == 1) {
          min = check(1, ranges, min);
      }
      else {
          min = check(0, ranges, min);
      }
      int[] ranges2 = {ar[1] - ar[0], ar[2] - ar[1]}; 
      Arrays.sort(ranges2); 
      int maxRange = ranges2[1];
      if (maxRange == ar[1] - ar[0]) {
          max = ar[1]- ar[0];
      }
      else if (maxRange == ar[2] - ar[1]) {
          max = ar[2] - ar[1];
      }
      pw.println(min);pw.println(max -1);
      pw.close();
   }
}
