import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Drought {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("whatbase.in"));
        //PrintWriter pw = new PrintWriter("whatbase.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            long total = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long[] nums = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                long num = Integer.parseInt(st.nextToken());
                nums[j] = num; 
            }
            boolean term = false;
            for (int j = 0; j < N - 1; j++) {
                if (nums[j + 1] > nums[j]) { // 0 0 0
                    if (j + 2 >= N) {
                        pw.println(-1);
                        term = true;
                        break;
                    }
                    long diff = nums[j + 1] - nums[j];
                    nums[j + 1] -= diff;
                    nums[j + 2] -= diff;
                    if (nums[j + 2] < 0) {
                        pw.println(-1);
                        term = true;
                        break;
                    }
                    total += diff * 2;
                }
                else if (nums[j] > nums[j + 1]) {
                    if (j % 2 == 0) {
                        pw.println(-1);
                        term = true;
                        break;
                    }
                    long diff = nums[j] - nums[j + 1];
                    total += diff * (j + 1);
                }
            }
            if (!term)  pw.println(total);
        }
        pw.close(); 
    }
}

