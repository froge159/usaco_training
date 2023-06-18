import java.util.*;
import java.io.*;

public class kayaking {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] weights = new int[n*2];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n*2; i++) {
         weights[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(weights);
      int ans = (int) 1e9;

      for (int i = 0; i < n*2; i++) {
         for (int j = i + 1; j < n*2; j++) {
            ArrayList<Integer> v = new ArrayList<>();
            for (int k = 0; k < n*2; k++) {
               if (k != i && k != j) {v.add(weights[k]);}
            }
            int temp = 0;
            for (int x = 0; x < v.size(); x += 2) {
               temp += v.get(x+1) - v.get(x);
            }
            ans = Math.min(ans,temp);
         }
      }
      System.out.println(ans);
   }
}
