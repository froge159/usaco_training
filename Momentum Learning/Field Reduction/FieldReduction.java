import java.util.*;
import java.io.*;

public class Main {
   static ArrayList<ArrayList<Integer>> linePts = new ArrayList<>();
	static int area(ArrayList<Integer> x, ArrayList<Integer> y) { // takes sorted list
		return (x.get(x.size() - 1) - x.get(0)) * (y.get(y.size() - 1) - y.get(0));
	}
	static void onBorder(ArrayList<Integer> xc, ArrayList<Integer> yc, ArrayList<Integer> pt) {
		ArrayList<ArrayList<Integer>> onPoints = new ArrayList<>();
		if (pt.get(0) == xc.get(0) && yc.get(0) <= pt.get(1) && yc.get(1) >= pt.get(1)) {
			linePts.add(pt)
		}
      if (pt.get(0) == xc.get(1) && yc.get(0) <= pt.get(1) && pt.get(1) <= yc.get(1)) {
			linePts.add(pt)
		}
      if (pt.get(1) == yc.get(0) && xc.get(0) <= pt.get(0) && pt.get(0) <= xc.get(1)) {
			linePts.add(pt)
		}
      if (pt.get(1) == yc.get(1) && xc.get(0) <= pt.get(0) && pt.get(0) <= xc.get(1)) {
			linePts.add(pt)
		}
	}
	public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         ArrayList<ArrayList<Integer>> pts = new ArrayList<>(); // all points
         ArrayList<Integer> x = new ArrayList<>();
         ArrayList<Integer> y = new ArrayList<>();
         ArrayList<Integer> xc = new ArrayList<>(); // ordered x points
         ArrayList<Integer> yc = new ArrayList<>(); // ordered y points
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
            int maxArea = Integer.MIN_VALUE;
            for (int j = 0; j < pts.size(); j++) {
               ArrayList<Integer> idk = onBorder(pts.get(j));
               if (idk.size() > 0) {
                  
               }
            }

         }
         

    }    
}
