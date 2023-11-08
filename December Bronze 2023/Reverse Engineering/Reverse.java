/*
create array containing subarray[input, output]

iterating through all input/outputs:
       iterate through every possible conditional value:
             iterate through previous i/o
                   if does not satisfy, try new conditional value
             if satisfies all previous i/o, continue
        if iterated through every possible value, print LIE

        
find new conditional value:
    for every index:
         if val == x return y
*/
import java.util.*;
import java.io.*;

public class Main {
    static void solve(PrintWriter pw, String[][] arr) {

    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nexToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[][] arr = new String[M][2];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = st.nextToken();
                arr[j][1] = st.nextToken();
            }
            solve(pw, arr);
        }
        pw.close();
    }
}
