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
        st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int leftc = 0; int rightc = 0;
            
            if (i <= N - 3 && arr[i + 1] != arr[i] && arr[i + 2] != arr[i]) {
                for (int j = i + 1; arr[j] != arr[i] && j < N - 1; j++) {
                    rightc++;
                }
            }
            if (i >= 2 && arr[i - 1] != arr[i] && arr[i - 2] != arr[i]) {
                for (int j = i - 1; arr[j] != arr[i] && j > 0; j--) {
                    leftc++;
                }
            }
            if (i >= 1 && i < N - 1 && arr[i + 1] != arr[i] && arr[i - 1] != arr[i]) {
                for (int j = i + 1; arr[j] != arr[i] && j < N - 1; j++) {
                    rightc++;
                }
                for (int j = i - 1; arr[j] != arr[i] && j > 0; j--) {
                    leftc++;
                }
                count++;
            }
            count += (rightc > 0) ? rightc - 1 : 0;
            count += (leftc > 0) ? leftc - 1 : 0;
        }
        pw.println(count);
        pw.close();
    }
}
