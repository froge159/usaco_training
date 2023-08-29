/*
   Samuel Xie
   Period 7
*/
import java.util.*;
import java.io.*;
public class temporaryFile {  
   public static void main(String[] args) throws IOException {
      // how many fences have height of at least n [3, 1, 1] [at least 1, at least 2, at least 3]
      // create array starting from 0 of different heights
      // iterate through array, increase the count of that index.
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());      
      for (int i = 0; i < T; i++) {
         st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         int[] old = new int[N];
         int[] newArr = new int[N];
         for (int j = 0; j < N; j++) {
            int num = Integer.parseInt(st.nextToken());
            old[j] = num;
            for (int k = 0; k < N; i++) {
               if (k + 1 <= num) {
                  newArr[k]++;
               }
            }
         }
         if (old.equals(newArr)) pw.println("YES");
         else pw.println("NO");
      }
   }
}
