import java.util.*;
import java.io.*;

public class Sleeping {
    static void solve(PrintWriter pw, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
            int target = 0;
            groups.add(new ArrayList<Integer>());
            for (int j = 0; j <= i; j++) {
                target += nums[j];
                groups.get(0).add(nums[j]);
            }
            int curr = target;
            boolean breaked = false;
            int total = 0;
            for (int j = i + 1; j < nums.length; j++) {
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
            if (curr != target) continue;
            //if (nums[0] == 0) pw.println(groups.toString());
            total += groups.get(groups.size() - 1).size() - 1;
            if (!breaked) {pw.println(total); return;}
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
