import java.util.*;
import java.io.*;

public class HoofBall {
    static int[] nums;
    static int solve(int index) {
        if (index == 0) { return index + 1;}
        if (index == nums.length - 1) return index - 1;
        if (nums[index + 1] - nums[index] < nums[index] - nums[index - 1]) return index + 1;
        return index - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter pw = new PrintWriter("hoofball.out");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int[] cows = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {cows[solve(i)]++;}
        for (int i = 0; i < N; i++) {
            if (cows[i] == 0) count++;
            if (solve(i) == i + 1 && solve(i + 1) == i && cows[i] == 1 && cows[i + 1] == 1) count++;
        }
        pw.println(count);
        pw.close();
    }
}
