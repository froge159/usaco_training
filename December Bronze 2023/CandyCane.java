import java.util.*;
import java.io.*;

public class CandyCane {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] cows = new long[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long candyH = Long.parseLong(st.nextToken());
            long min = 1; long max = candyH;
            for (int j = 0; j < cows.length; j++) {
                if (min <= cows[j]) {
                    long temp = cows[j];
                    if (temp >= max) {
                        cows[j] += max - min + 1;
                        break;
                    }
                    cows[j] += temp - min + 1;
                    min = temp + 1;
                }
            }
        }
        for (long i: cows)pw.println(i);
        pw.close();

    }
}
