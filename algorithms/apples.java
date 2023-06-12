import java.io.*;
import java.util.*;

public class AppleDivision {
	static int n;
	static int[] weights;

	public static void main(String[] args) throws Exception {
		Kattio io = new Kattio();

		n = io.nextInt();
		weights = new int[n];
		for (int i = 0; i < n; i++) { weights[i] = io.nextInt(); }

		// Solve the problem starting at apple 0 with both sets being empty
		io.println(recurseApples(0, 0, 0));
		io.close();
	}

	static long recurseApples(int index, long sum1, long sum2) {
		// We've added all apples- return the absolute difference
		if (index == n) { return Math.abs(sum1 - sum2); }

		// Try adding the current apple to either the first or second set
		return Math.min(recurseApples(index + 1, sum1 + weights[index], sum2),
		                recurseApples(index + 1, sum1, sum2 + weights[index]));
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
	//EndCodeSnip
}
