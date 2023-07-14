import java.io.*;
import java.util.*;
public class OddPhotos {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
        int n = io.nextInt();
        int o = 0; int e = 0;
        for (int i = 0; i < n; i++) {
            int j = io.nextInt();
            if (j % 2 == 0) {e++;}
            else {o++;}
        } 
        if (o == e || e == o + 1) {io.println(n);}
        else {
            while (o > e) {
                o -= 2; e++;
            }
            if (e > o + 1) {
                e = o + 1;
            }
        }
        io.println(e + o);
        io.close();
      
    }
	//BeginCodeSnip{Kattio}
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}	//EndCodeSnip
