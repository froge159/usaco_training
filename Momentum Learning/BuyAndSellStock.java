import java.util.*;
import java.io.*;

public class BuyAndSellStock {
   public static void main(String[] args) throws IOException {
         // BufferedReader br = new BufferedReader(new FileReader("input.in"));
         // PrintWriter pw = new PrintWriter("output.out");
         // 4 
         // 1 2 3 4
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         int[] nums = new int[N];
         boolean owned = false;
         int total = 0;
         for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
         }
         // if next element 
         for (int i = 0; i < N; i++) {
            if (i == 0) {
               if (total - nums[i] + nums[i + 1] > 0){
                  total -= nums[i]; 
                  owned = true;
               }
            }
            else if (i == N - 1) {
               if (owned) total -= nums[i];
               break;
            }

            else if (owned) {
               total += nums[i];
               owned = false;
            }

            else if (nums[i + 1]> nums[i]) {
               total -= nums[i];
               owned = true;
            }
         }
         pw.println(total);
         pw.close();

   }
}
