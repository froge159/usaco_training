import java.util.*;
import java.io.*;

public class FieldReduction {
	static int area(ArrayList<Integer> x, ArrayList<Integer> y) {
		return (x.get(x.size() - 1) - x.get(0)) * (y.get(y.size() - 1) - y.get(0));
	}
	static ArrayList<Integer> onBorder(ArrayList<Integer> xc, ArrayList<Integer> yc, ArrayList<Integer> pt) {
		ArrayList<ArrayList<Integer>> onPoints = new ArrayList<>();
		int[] borders = new int[4];
			borders[0] = xc.get(0);
			borders[1] = xc.get(xc.size() - 1);
			borders[2] = yc.get(0);
			borders[3] = yc.get(yc.size() - 1);
		if (pt.get(0) == xc.get(0) && yc.get(0) <= pt.get(1) && yc.get(1) >= pt.get(1)) {
			onPoints.add()
		}
	}
	public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> pts = new ArrayList<>();
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		ArrayList<Integer> xc = new ArrayList<>();
		ArrayList<Integer> yc = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			pts.add(new ArrayList<Integer>());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
    		pts.get(i).add(a); x.add(a); xc.add(a);
            pts.get(i).add(b); y.add(b); yc.add(b);
        }
		Collections.sort(xc); Collections.sort(yc);
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> linePts = new ArrayList<>();

			for (int j = 0; j < pts.size(); j++) {
				
			}
		}


    }    
}
