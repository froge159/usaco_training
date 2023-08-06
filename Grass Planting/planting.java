import java.util.*;
import java.io.*;

public class planting {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		PrintWriter pw = new PrintWriter("planting.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<LinkedList<Integer>> x = new ArrayList<LinkedList<Integer>>(n);
		for (int i = 0; i < n; i++) {
			x.add(new LinkedList<Integer>());
		}
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			x.get(a-1).addFirst(b);
			x.get(b-1).addFirst(a);
		}
		int temp = -1;
		for (int i = 0; i < x.size(); i++) {
			if (x.get(i).size() > temp) {
				temp = x.get(i).size();
			}
		}
		//pw.println(x.toString());
		pw.println(temp + 1);
		pw.close();
	}
}
