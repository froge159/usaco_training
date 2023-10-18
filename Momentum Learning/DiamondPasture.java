import java.util.*;
import java.io.*;

public class Main {
    // create boolean array that holds cells that are in the diamond or not. clear it after every new diamond set
    // for each diamond set, loop through grid values and add to count if its corresponding place is marked true
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[][] grid = new int[N + 1][M + 1]; // note that grid starts at index [1][1]
        boolean[][] dmdsGrid = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < Q; i++) { // 1 * 2 * 2 * 2
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // xpos
            int b = Integer.parseInt(st.nextToken());// ypos
            int c = Integer.parseInt(st.nextToken()); // diagonal len
            int yVal = 1;
            for (int x = a - c; x <= a + c; x++) {
                if (yVal == 1) {
                    dmdsGrid[x][b] = true;
                }
            }
        }
        
        pw.close();
    }
}
