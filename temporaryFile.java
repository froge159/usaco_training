import java.util.*;
import java.io.*;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter pw = new PrintWriter(System.out);
    /*
    remove duplicates from each arr

    */
    static void solve() { 
        int n = in.nextInt(); int m = in.nextInt(); int k = in.nextInt();
		int[] a = new int[n]; int[] b = new int[m];
		for (int i = 0; i < n; i++) a[i] = in.nextInt();
		for (int i = 0; i < m; i++) b[i] = in.nextInt();
        Arrays.sort(a); Arrays.sort(b);

        int aCount = 0; int bCount = 0;
        int shared = 0;
        for (int i = 1; i <= k; i++) {
            int aInd = Arrays.binarySearch(a, i); int bInd = Arrays.binarySearch(b, i);
            if (aInd >= 0 && bInd < 0) aCount++;
            else if (bInd >= 0 && aInd < 0) bCount++;
            else if (aInd >= 0 && bInd >= 0) {
                shared++;
            }
            else {
                pw.println("NO"); return;
            }
        }
        while (shared > 0) {
            if (aCount < bCount) aCount++;
            else bCount++;
            shared--;
        }

        pw.println(aCount == bCount ? "YES" : "NO");
    }
    public static void main(String[] args) throws IOException {        
        int T = in.nextInt();
        while (T-- > 0) {
            solve();
        }
        pw.close();
    }
    
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
