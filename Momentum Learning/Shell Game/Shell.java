import java.util.*;
import java.io.*;

public class Shell {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new FileReader("shell.in"));
       PrintWriter pw = new PrintWriter("shell.out");
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken());
      int maxPoints = Integer.MIN_VALUE;
      int[][] nums = new int[K][3];
      for (int i = 0; i < K; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 3; j++) {
            nums[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      for (int i = 1; i <= K; i++) { // tests new position every time
         ArrayList<Integer> x = new ArrayList<>(); x.add(0); x.add(1); x.add(2); x.add(3);
         int curr = i;
         int temp = 0;
         for (int j = 0; j < K; j++) { // loops through all swaps
            int a = nums[j][0]; int b = nums[j][1]; int guess = nums[j][2];
            Collections.swap(x, a, b);
            if (curr == a) curr = b;
            else if (curr == b) curr = a;
            if (guess == curr) temp++;
         }
         if (temp > maxPoints) maxPoints = temp;
      }
      pw.println(maxPoints);
      pw.close();
   }
}
