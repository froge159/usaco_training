import java.io.*;
import java.util.*;

public class lineup {
	// Assumed to be in sorted order (which it is)
	static final String[] COWS =
	    new String[] {"Beatrice", "Belinda", "Bella",     "Bessie",
	                  "Betsy",    "Blue",    "Buttercup", "Sue"};

	public static void main(String[] args) throws IOException {
		Map<String, Integer> cowInds = new HashMap<>();
		for (int i = 0; i < COWS.length; i++) { cowInds.put(COWS[i], i); }
    	BufferedReader read = new BufferedReader(new FileReader("lineup.in"));
    	PrintWriter out = new PrintWriter("lineup.out");
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter out = new PrintWriter(System.out);
		int reqNum = Integer.parseInt(read.readLine());

		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>(COWS.length);
		for (int c = 0; c < COWS.length; c++) {
			neighbors.add(new ArrayList<>());
		}
		for (int r = 0; r < reqNum; r++) {
			String[] words = read.readLine().split(" ");

			int cow1 = cowInds.get(words[0]);
			int cow2 = cowInds.get(words[words.length - 1]);
			neighbors.get(cow1).add(cow2);
			neighbors.get(cow2).add(cow1);
		}
    //System.out.println(neighbors.toString());
		List<Integer> order = new ArrayList<>();
		boolean[] added = new boolean[COWS.length];
		for (int c = 0; c < COWS.length; c++) {
			if (!added[c] && neighbors.get(c).size() <= 1) {
				added[c] = true;
				order.add(c);

				if (neighbors.get(c).size() == 1) {
					int prev = c;
					int at = neighbors.get(c).get(0);
					while (neighbors.get(at).size() == 2) {
						added[at] = true;
						order.add(at);

						int a = neighbors.get(at).get(0);
						int b = neighbors.get(at).get(1);
						int temp_at = a == prev ? b : a;
						prev = at;
						at = temp_at;
					}
					added[at] = true;
					order.add(at);
				}
			}
		}

		for (int c : order) { out.println(COWS[c]); }
		out.close();
	}
}

