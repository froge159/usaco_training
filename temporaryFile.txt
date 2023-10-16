import java.util.*;
import java.io.*;

class Make24 {
    static int count = 0;
    static void solve(int[] nums, int res) {
        int n = nums.length;
        int[] p = new int[n];
        int i = 1;
        while (i < n) {
            if (p[i] < i) {
                int j = ((i % 2) == 0) ? 0 : p[i];
                swap(nums, i, j);
                if (loop(nums, res))  {
                    count++;
                    return;
                }
                p[i]++;
                i = 1;
            }
            else {
                p[i] = 0;
                i++;
            }
        }
    }
    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    } 
    static boolean loop(int[] nums, int res) {
        // + - * /
        double result = 0;
        boolean matched = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    result = nums[0];
                    result = operate(nums, i, result, 1);
                    result = operate(nums, j, result, 2);
                    result = operate(nums, k, result, 3);
                    if (result == res) {
                        matched = true; 
                    }
                }
            }
        }
        return matched;
    }
    static double operate(int[] nums, int index, double result, int currIndex) {
        if (index == 0) return result + nums[currIndex];
        if (index == 1) return result - nums[currIndex];
        if (index == 2) return result * nums[currIndex];
        else return result / nums[currIndex];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int res = Integer.parseInt(st.nextToken());
            int[] nums = {a, b, c, d};
            solve(nums, res);
        }
        pw.println(count);
        pw.close();
    }
}
