import java.util.*;
import java.io.*;

public class A {
    static void solve(int[][] arr, PrintWriter pw) {
        
    }
    public static void main(String[] args) throws IOException {
        CP cp = new CP();
        int T = cp.toInt(cp.readLine());
        while (T-- > 0) {
            
        }
    }
}


class CP {
    BufferedReader br;
    PrintWriter pw;
    StringTokenizer st;
    // tokenizeLine, readLine, nextString, nextInt, nextLong, close, 
    public CP() {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
    }
    public void tokenizeLine() throws IOException { 
        st = new StringTokenizer(br.readLine());
    }
    public String readLine() throws IOException { 
        return br.readLine();
    }
    public int toInt(String line) {
        return Integer.parseInt(line);
    }


    public String nextString() throws IOException { 
        return st.nextToken();
    }
    public int nextInt() throws IOException { 
        return Integer.parseInt(st.nextToken());
    }
    public long nextLong() throws IOException { 
        return Long.parseLong(st.nextToken());
    }

    
    public void println(char x) {pw.println(x);}
    public void println(String x) {pw.println(x);}
    public void println(int x) {pw.println(x);}
    public void println(double x) {pw.println(x);}
    public void println(long x) {pw.println(x);}
    public void print(char x) {pw.print(x);}
    public void print(String x) {pw.print(x);}
    public void print(int x) {pw.print(x);}
    public void print(double x) {pw.print(x);}
    public void print(long x) {pw.print(x);}
    public void println(StringBuilder sb) {pw.println(sb);}

    public void close() throws IOException { // closes
        br.close(); pw.close();
    }

}
