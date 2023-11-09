import java.util.*;
import java.io.*;

public class Sleeping {
    static void solve(PrintWriter pw, int[] nums, int sum, ArrayList<Integer> factors) {
        int min  = Integer.MAX_VALUE;
        for (int i: factors) {
            if (sum % i != 0) continue;
            ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
            int target = 0;
            groups.add(new ArrayList<Integer>());
            int start = 0;
            for (int j = 0; target < sum / i; j++) {
                target += nums[j];
                groups.get(0).add(nums[j]);
                start = j;
            }
            int curr = target;
            boolean breaked = false;
            int total = 0;
            for (int j = start + 1; j < nums.length; j++) {
                if (nums[j] + curr > target || nums[j] == target) {
                    if (curr != target) {  breaked = true; break;}
                    total += groups.get(groups.size() - 1).size() - 1;
                    groups.add(new ArrayList<Integer>());
                    groups.get(groups.size() - 1).add(nums[j]);
                    curr = nums[j];
                }
                else {
                    groups.get(groups.size() - 1).add(nums[j]);
                    curr += nums[j];
                }
            }
            //pw.println(groups.toString());
            if (curr != target) continue;
            total += groups.get(groups.size() - 1).size() - 1;
            if (!breaked)  {
                if (total < min) min = total;
            }
        }
        pw.println(min);
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
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                nums[j] = a;
                sum += a;
            }
            if (sum == 0) {pw.println(0); continue;}
            ArrayList<Integer> factors = new ArrayList<>();
            for (int j = 1; j <= (int) Math.sqrt(sum); j++) {
                if (sum % j == 0) {
                    factors.add(j);
                    factors.add(sum / j);
                }
            }
            solve(pw, nums, sum, factors);
        }
        pw.close();
    }
}
