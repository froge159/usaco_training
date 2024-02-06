import java.util.*;
import java.io.*;

public class Solve {
    static FastReader in = new FastReader();
    static PrintWriter pw = new PrintWriter(System.out);
    /*
    notes
    */
    static void solve() { 
        

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
