import java.util.*;
import java.io.*;

public class Main {
    static void solve(PrintWriter pw, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int target = 0;
            for (int j = 0; j <= i; j++) {
                if (target > 0) count++;
                target += nums[j];
            }
            int curr = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (curr > 0) count++;
                curr += nums[j];
                if (curr == target) {
                    curr = 0;
                }
                else if (curr > target) {
                    count = 0; break;
                }
            }
            if (count > 0) { pw.println(count); return;}
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
            st = new StringTokenizer(br.readLine());
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }
            solve(pw, nums);
        }
        pw.close();
    }
}
