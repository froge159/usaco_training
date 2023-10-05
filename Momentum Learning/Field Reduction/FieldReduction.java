import java.util.*;
import java.io.*;

public class FieldReduction {
	static int N;
	static int area(ArrayList<Integer> x, ArrayList<Integer> y, int startx, int endx, int starty, int endy) { // takes sorted list
		return (x.get(startx) - x.get(endx)) * (y.get(starty) - y.get(endy));
	}
	static int[] onBorder(ArrayList<Integer> xc, ArrayList<Integer> yc, ArrayList<Integer> pt) {
		int[] points = new int[4];
		if (pt.get(0) == xc.get(0) && yc.get(0) <= pt.get(1) && yc.get(N - 1) >= pt.get(1)) {
         points[0] = 1;
		}
      if (pt.get(0) == xc.get(N - 1) && yc.get(0) <= pt.get(1) && pt.get(1) <= yc.get(N - 1)) {
         points[1] = 2;
		}
      if (pt.get(1) == yc.get(0) && xc.get(0) <= pt.get(0) && pt.get(0) <= xc.get(N - 1)) {
         points[2] = 3;
		}
      if (pt.get(1) == yc.get(N - 1) && xc.get(0) <= pt.get(0) && pt.get(0) <= xc.get(N - 1)) {
         points[3] = 4;
		}
      return points;
	}
	public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         ArrayList<ArrayList<Integer>> pts = new ArrayList<>(); // all points
         ArrayList<Integer> xc = new ArrayList<>(); // ordered x points
         ArrayList<Integer> yc = new ArrayList<>(); // ordered y points
         for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pts.add(new ArrayList<Integer>());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pts.get(i).add(a);  xc.add(a);
            pts.get(i).add(b); yc.add(b);
         }
         Collections.sort(xc); Collections.sort(yc);
		 // 1 4 7 8 10 50
		 // 1 7 8 9 12 100
		 ArrayList<Integer> removed = new ArrayList<>();
		 ArrayList<Integer> temp = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
            int maxArea = -1;
            for (int j = 0; j < pts.size(); j++) {
				if (removed.contains(j)) continue;
				int startx = N - 1; int endx = 0;
		 		int starty = N - 1; int endy = 0;
                int[] faces = onBorder(xc, yc, pts.get(j));
                // left has min x, right has max x
                // bottom has min y, top has max y
				if (faces.length > 0) {
					for (int z: faces) {
						if (z == 1) {
							endx++;
						}
						if (z == 2) {
							startx--;
						}
						if (z == 3) {
							endy++;
						}
						if (z == 4) {
							starty--;
						}
					}
					int area = area(xc, yc, startx, endx, starty, endy);
					if (maxArea == -1) {maxArea = area; temp.add(j);}
					else if (maxArea < area) {maxArea = area; temp.add(j);}
				}
            }
			int re = temp.get(temp.size() - 1);
			temp.clear(); removed.add(re);
        }
		int smallx = Integer.MAX_VALUE; int smally = Integer.MAX_VALUE;
		int largex = Integer.MIN_VALUE; int largey = Integer.MIN_VALUE;
		for (int i = 0; i < pts.size(); i++) {
			if (i == removed.get(0) || i == removed.get(1) || i == removed.get(2)) {
				pts.get(i).clear();
			}
			else {
				if (pts.get(i).get(0) < smallx) smallx = pts.get(i).get(0);
				if (pts.get(i).get(0) > largex) largex = pts.get(i).get(0);
				if (pts.get(i).get(1) < smally) smally = pts.get(i).get(1);
				if (pts.get(i).get(1) > largey) largey = pts.get(i).get(1);
			}

		}
		pw.println(removed.toString());
		pw.println((largex - smallx) * (largey - smally));
		pw.close();
         

    }    
}
