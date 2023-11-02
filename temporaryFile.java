import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] rule = new int[N]; // changes
        int[] orig = new int[N]; // test
        for (int i = 0; i < N; i++) {
            rule[i] = Integer.parseInt(st.nextToken());
            orig[i] = i + 1;
        }
        int[] test = orig.clone();
        for (int i = 0; i < K; i++) {
            int[] newArr = new int[N];
            for (int j = 0; j < N; j++) {
                newArr[rule[j] - 1] = test[j];
            }
            test = newArr.clone();
        }
        int empty = 0;
        int stationary = 0;
        int j = 0;
        for (int i: test) {
            if (i == 0) empty++;
            if (i == orig[j]) stationary++;
            j++;
        }
        pw.println(1000 * stationary + empty);
        pw.close();
    }
}
