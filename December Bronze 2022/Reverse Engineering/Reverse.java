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
1
1 2
1 0
1 1
*/

import java.util.*;
import java.io.*;

public class Reverse {
    static void solve(PrintWriter pw, String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            String in = arr[i][0]; 
            String out = arr[i][1];
            boolean found = false;
            for (int j = 0; j < in.length(); j++) {
                // if j == 
                boolean satisfies = true;
                for (int k = 0; k < i; k++) {
                    if ((arr[k][0].substring(j, j + 1).equals(in.substring(j, j + 1)) && !arr[k][1].equals(out)) 
                         || (!arr[k][0].substring(j,j+1).equals(in.substring(j, j + 1)) && !arr[k][1].equals(out))) {
                        satisfies = false;
                        break;
                    }
                }
                if (satisfies) {
                    found = true;
                    break;
                }
            }
            if (!found) { pw.println("LIE"); return;}
        }
        pw.println("OK");
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
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
