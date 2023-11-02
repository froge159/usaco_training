import java.util.*;
import java.io.*;

public class LongestConsecutiveBlock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/samjh/OneDrive/Documents/Coding/cp/src/input.txt/"));
        // PrintWriter pw = new PrintWriter("output.out");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> nums = new ArrayList<>();
        int count = 0;
        int res = Integer.MIN_VALUE;
        boolean counting = false;
        int previous = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)  {
            int x = Integer.parseInt(st.nextToken());
            if (x % 2 != 0) nums.add(x);
        }
        Collections.sort(nums);
        // 1 2 3 4 5 9  11
        for (int i = 0; i < nums.size() ; i++) {
            if (nums.get(i) % 2 != 0 && !counting) {
                count++;
                counting = true;
            }
            else if (nums.get(i) % 2 != 0) {
                if (nums.get(i) == previous + 2) {
                    count++;
                    if (i == nums.size() - 1) {
                        if (count > res) res = count;
                    }
                }
                else {
                    if (count > res) res = count;
                    count = 0;
                }
            }
            if (nums.get(i) % 2 != 0) previous = nums.get(i);
        }
        pw.println((nums.size() == 0) ? 0 : res);
        //pw.println(nums.toString());
        pw.close();
    }
}
