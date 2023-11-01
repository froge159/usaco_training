import java.util.*;
import java.io.*;

public class Feeding {
    static void solve(char[] nums, int K) {
        int count = 0;
        boolean[] grass = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            
        }
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            char[] nums = st.nextToken().toCharArray();
            solve(nums, K);
        }
        pw.close();
    }
}
