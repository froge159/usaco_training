import java.util.*;
import java.io.*;

public class CowntactTrace {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        ArrayList<Integer> rngs = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1') size++;
            if (size > 0 && line.charAt(i) == '0') {
                rngs.add(size); size = 0;
            }
        } if (size > 0) rngs.add(size);
        
        int day = Integer.MAX_VALUE;
        int s = 0; int e = rngs.size() - 1;
        if (line.charAt(0) == '1') {
            day = Math.min(day, rngs.get(0) - 1);
            s++;
        }
        if (line.charAt(N - 1) == '1') {
            day = Math.min(day, rngs.get(rngs.size() - 1) - 1);
            e--;
        }
        for (int i = s; i <= e; i++) {
            if (i % 2 == 1) day = Math.min(day, (rngs.get(i) - 1) / 2);
            else day = Math.min(day, (rngs.get(i) - 2) / 2);
        }
        int sum = 0;
        for (int i: rngs) {
            sum += Math.ceil(i / (2 * (double) day + 1));
        }
        pw.println(sum);
        pw.close();
    }
}
