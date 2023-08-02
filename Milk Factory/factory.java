import java.io.*;
import java.util.*;
public class factory {
	static ArrayList<LinkedList<Integer>> x;
	static boolean[] visited;
	static boolean found = false;
	static void search (int v, boolean visited[], int target) { // 5 1
		visited[v-1] = true;
        Iterator<Integer> i = x.get(v-1).listIterator();
        while (i.hasNext()) {
            int n = i.next(); //System.out.println(n);
			if (n == target) {
				found = true;
			}
            if (!visited[n-1]) {
                search(n, visited, target);
			}
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("factory.in"));
		PrintWriter pw = new PrintWriter("factory.out");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		x = new ArrayList<>(n);
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			x.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());
			x.get(start-1).addFirst(last);
		}
		// [1, 2] [2] [3, 2] [4, 1, 3]
		// [2] [] [2] [1, 3] 
		// 4 goes to 1 which goes to 2
		for (int i = 0; i < n-1; i++) { // 1 (i + 1)
			boolean end = false;
			for (int j = 0; j < n-1; j++) { // 3 (j + 1)
				found = false;
				if (i == j) {continue;}
				visited = new boolean[n];
				search(j + 1, visited, i + 1);
				if (!found) {
					end = true; break;
				}
			}
			if (!end) {pw.println(i + 1); pw.close();}
		}
		pw.println(-1);
		pw.close();
    }
	
}
