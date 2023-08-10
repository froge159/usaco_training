import java.util.*;
import java.io.*;

public class doesntwork {
	static ArrayList<ArrayList<Integer>> p;
	static int area = 0;
	static ArrayList<Integer> x;
	static ArrayList<Integer> y;
	static int indexes[];
	public static int search(ArrayList<Integer> arr, int x) {
        int left = 0, right = arr.size() - 1;
       
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == x)
                return mid;
            if (arr.get(mid) < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    } // 
	public static int area(List<Integer> xc, List<Integer> yc) {
		return Math.abs(xc.get(xc.size()-1)-xc.get(0)) * Math.abs(yc.get(yc.size()-1)-yc.get(0));
	}
	public static void remove(ArrayList<Integer> x, ArrayList<Integer> y, int[] indexes, ArrayList<Integer> set) { // removes generated subsets elements
		ArrayList<Integer> xc = new ArrayList<>(x);
		ArrayList<Integer> yc = new ArrayList<>(y);
		for (int i = 0; i < set.size(); i++) {
			try {
				xc.remove(search(xc, p.get(set.get(i)).get(0)));
			}
			catch (Exception e) {
				try {
					yc.remove(search(yc, p.get(set.get(i)).get(1)));
					continue;
				}
				catch (Exception f) {continue;}
			}
			try {yc.remove(search(yc, p.get(set.get(i)).get(1)));}
			catch (Exception idkwhattonamethis) {continue;}
		}
		if (area(xc, yc) < area) {area = area(xc, yc);}
	}
	public static void powerSet(int[] indexes, int index, ArrayList<Integer> curr) {
        int n = indexes.length;
 
        // base case
        if (index == n) {
            return;
        }
 
        // First print current subset
        if (curr.size() < 4 && curr.size() > 0) {System.out.println(curr.toString());}; 
 
        // Try appending remaining characters
        // to current subset
        for (int i = index + 1; i < n; i++) {
			if (curr.size() < 3) {  // Modify this condition to allow subsets of size less than 4
				curr.add(indexes[i]);
				powerSet(indexes, i, curr);
				curr.remove(curr.size() - 1);  // Backtrack by removing the last added element
			}
		}
	}
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
		PrintWriter pw = new PrintWriter("reduce.out");
		// 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		x = new ArrayList<>(N);
		y = new ArrayList<>(N);
		int[] xo = new int[N];
		int[] yo = new int[N];
		p = new ArrayList<>(N);
		ArrayList<Integer> set = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			p.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
			x.add(a); y.add(b); xo[i] = a; yo[i] = b;
			p.get(i).add(a); p.get(i).add(b);
		}
		Collections.sort(x); Collections.sort(y);
		// get all small and large values  indexing by searching through original x and y array
		// generate all subsets and find the smallest areas
		area = Math.abs(x.get(N-1)-x.get(0)) * Math.abs(y.get(N-1)-y.get(0));
		int smallx = x.get(0); int largex = x.get(N-1);
		int smally = y.get(0); int largey = y.get(N-1);
		indexes = new int[4];
		for (int i = 0; i < N; i++) { 
			if (smallx == xo[i]) {indexes[0] = i;}
			if (largex == xo[i]) {indexes[1] = i;}
			if (smally == yo[i]) {indexes[2] = i;}
			if (largey == yo[i]) {indexes[3] = i;}
		} 
		powerSet(indexes, -1, set);
		
		pw.println(area);
		pw.close();
	}
}
