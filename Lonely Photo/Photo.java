import java.util.*;
import java.io.*;
// http://www.usaco.org/index.php?page=viewproblem2&cpid=1155
public class Photo {
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
            
            if (i >= 1 && i < N - 1 && arr[i + 1] != arr[i] && arr[i - 1] != arr[i]) {
                for (int j = i + 1; j <= N - 1; j++) {
                    if (arr[j] == arr[i]) break;
                    rightc++;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] == arr[i]) break;
                    leftc++;
                }
            }
            else if (i <= N - 3 && arr[i + 1] != arr[i] && arr[i + 2] != arr[i]) {
                for (int j = i + 1; j <= N - 1; j++) {
                    if (arr[j] == arr[i]) break;
                    rightc++;
                }
            }
            else if (i >= 2 && arr[i - 1] != arr[i] && arr[i - 2] != arr[i]) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] == arr[i]) break;
                    leftc++;
                }
            }
            count += (leftc > 0) ? leftc - 1: 0;
            count += (rightc > 0) ? rightc - 1 : 0;
            count += leftc * rightc;
        }
        pw.println(count);
        pw.close();
    }
}
