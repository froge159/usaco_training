import java.util.*;
import java.io.*;

public class BuyAndSellStock {
   public static void main(String[] args) throws IOException {
         // BufferedReader br = new BufferedReader(new FileReader("input.in"));
         // PrlongWriter pw = new PrlongWriter("output.out");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         long[] nums = new long[N];
         boolean owned = false;
         long total = 0;
         for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
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
