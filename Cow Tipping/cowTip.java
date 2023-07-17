import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int count = 0;
	static char[][] arr;
	static void flip(int row, int column) {
		// 2 2 
		for (int i = 0; i <= row; i++) {
			for (int j = 0; j <= column; j++) {
				if (arr[i][j] == '0') {
					arr[i][j] = '1'; continue;
				}
				else {arr[i][j] = '0';}
			}
		}
		count++;
	}
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("cowtip");
        n = io.nextInt();
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = io.next();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		count = 0;
		for (int i = n-1; i >= 0; i--) {
			for (int j = n-1; j >= 0; j--) {
				if (arr[i][j] != '0') {
					flip(i, j);
				}
			}
		}
		io.println(count);
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
