import java.util.*;
import java.io.*;

public class Main {
    static boolean[] held;
    static int[] cows;
    static PrintWriter pw;
    static void subset(int[] indexes, ArrayList<Integer> curr) {
        int n = indexes.length;
 
        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1<<n); i++)
        { 
            // Print current subset
            for (int j = 0; j < n; j++)
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    curr.add(indexes[j]);
            sim(indexes, curr);
            curr.clear();
        }
    } 
    static void sim(int[] indexes, ArrayList<Integer> curr) {
        Arrays.fill(held, false);
        for (int i: curr) {
            boolean[] visited = new boolean[indexes.length];
            int currIndex = i;
            while (true) {
                if (currIndex == indexes.length - 1) currIndex--;
                else if (currIndex == 0) currIndex++; 
                else if (cows[currIndex + 1] - cows[currIndex] > cows[currIndex] - cows[currIndex - 1]) {
                    currIndex--;
                }
                else if (cows[currIndex + 1] - cows[currIndex] < cows[currIndex] - cows[currIndex - 1]) {
                    currIndex++; 
                }
                else {
                    currIndex--;
                }
                if (visited[currIndex]) break;
                visited[currIndex] = true;
                held[currIndex] = true;
            }
        }
        boolean[] check = new boolean[indexes.length];
        Arrays.fill(check, true);
        if (Arrays.equals(check, held)) {
            pw.println(curr.size());
            pw.close();
            System.exit(0);
        }
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        cows = new int[N];
        held = new boolean[N];
        int[] indexes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
            indexes[i] = i;
        }
        Arrays.sort(cows);
        ArrayList<Integer> curr = new ArrayList<>();
        subset(indexes, curr);
        pw.close();
    }
}
