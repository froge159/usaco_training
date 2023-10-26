import java.util.*;
import java.io.*;

public class HoofBall {
    static boolean[] held;
    static int[] cows;
    static PrintWriter pw;
    static void subset(int[] indexes, int index, ArrayList<Integer> curr) {
        int n = indexes.length;
        if (index == n) return;
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
                if (visited[currIndex] = true) break;
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
        for (int i = index + 1; i < n; i++) {
            curr.add(indexes[i]);
            subset(indexes, i, curr);
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < curr.size() - 1; j++) temp.add(curr.get(j));
            curr = temp;
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
        subset(indexes, -1, curr);
        pw.close();
    }
}
