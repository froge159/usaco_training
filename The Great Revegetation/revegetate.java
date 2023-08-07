import java.util.*;
import java.io.*;

public class revegetate {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter("revegetate.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		int min = 101;
		int[] grasses =  new int[n];
		int[] sys = new int[n];
		ArrayList<LinkedList<Integer>> x = new ArrayList<>(n);
		for (int i = 0; i < n; i++)  {
			x.add(new LinkedList<Integer>());
			grasses[i] = i + 1;
		} 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (min > Math.min(a, b)) {min = Math.min(a, b);}
			x.get(a-1).addFirst(b); 
			x.get(b-1).addFirst(a);
		}
		for (int i = 0; i < x.size(); i++) { // 1 0 0 0 0 
			if (i == 0) {sys[i] = 1; continue;}
			int[] clone = grasses.clone(); 
			for (int j: x.get(i)) {
				try {clone[sys[j-1] - 1] = 0;}
				catch (Exception e) {continue;}
			}
			for (int k: clone) {
				if (k != 0) {
					sys[i] = k; break;
				}
			}
		}
		//pw.println(x.toString());
		for (int i: sys) {
			pw.print(i);
		}
		pw.println();
		pw.close();
	}
}
