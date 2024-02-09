import java.util.*;
import java.io.*;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter pw = new PrintWriter(System.out);
    /*
    remove duplicates from each arr

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
    
    int[] prefSums(int[] arr) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i] + newArr[i];
        }
        return newArr;
    }
}
