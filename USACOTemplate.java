import java.util.*;
import java.io.*;
static BufferedReader br;
static PrintWriter pw;
static StringTokenizer st;

public class USACOTemplate {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        st = new StringTokenizer(br.readLine());

        pw.close();
    }
}
