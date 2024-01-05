import java.util.*;
import java.io.*;

public class Feeding {
    static void solve(char[] nums, int K, PrintWriter pw) { // k is max range
        int count = 0;
        char[] grass = new char[nums.length];
        boolean[] fed = new boolean[nums.length];
        Arrays.fill(grass, '.');
        int lastG = 0; int lastH = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] == 'G') {lastG = i; break;}
        for (int i = 0; i < nums.length; i++) if (nums[i] == 'H') {lastH = i; break;}
        for (int i = 0; i < nums.length; i++) {
            if (fed[i]) continue;
            if (i + K <= grass.length - 1) {
                grass[i + K] = nums[i];
            }
            else {
                for (int j = grass.length - 1; j >= 0; j--) {
                    if (grass[j] == '.') {
                        grass[j] = nums[i];
                        break;
                    }
                }
            }
            if (nums[i] == 'G') {
                for (int j = lastG; j <= i + K * 2 && j < nums.length; j++) {
                    if (nums[j] == nums[i]) {fed[j] = true; lastG = j;}
                }
                count++;
            }
            if (nums[i] == 'H') {
                for (int j = lastH; j <= i + K * 2 && j < nums.length; j++) {
                    if (nums[j] == nums[i]) {fed[j] = true; lastH = j;}
                }
                count++;
            }
        }
        pw.println(count);
        for (char i: grass) pw.print(i);
        pw.println();
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
            Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            char[] nums = st.nextToken().toCharArray();
            solve(nums, K, pw);
        }
        pw.close();
    }
}
