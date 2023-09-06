import java.util.*;
import java.io.*;
public class Fence {  
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
            int N = Integer.parseInt(st.nextToken()); // [3, 1, 0] [3, 1, 1]
            int[] old = new int[N];
            int[] newArr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                old[j] = num; 
                if (j == 0 && num != N) {
                    break;
                }
                for (int k = 1; k <= N; k++) {
                    if (num >= k) {
                        newArr[k - 1]++;
                        continue;
                    }
                }
                /* 
                for (int k = 0; k < N; k++) {
                    if (k + 1 <= num) {
                        newArr[k]++; 
                    }
                } */
            }

            if (Arrays.equals(old, newArr))  {
                pw.println("YES");
            }
            else  {
                pw.println("NO");
            }
        }
        pw.close();
   }
}
