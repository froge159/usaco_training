import java.util.*;
import java.io.*;

public class FieldReduction {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter("reduce.out");
         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
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
		 // 1 4 7 8 10 50
		 // 1 7 8 9 12 100
      int minArea = Integer.MAX_VALUE;
      Collections.sort(xc); Collections.sort(yc);
		for (int i = 0; i < pts.size(); i++) {
         //pw.println(xc.toString());
         int x = pts.get(i).get(0);
         int y = pts.get(i).get(1);
         int xIndex = Collections.binarySearch(xc, x);
         int yIndex = Collections.binarySearch(yc, y);
         xc.set(xIndex, 0); yc.set(yIndex, 0);
         int startx = 0; int starty = 0;
         int endx = N - 1; int endy = N - 1;
         if (xc.get(0) == 0) startx++;
         if (xc.get(N-1) == 0) endx--;
         if (yc.get(0) == 0) starty++;
         if (yc.get(N-1) == 0) endy--;
         int area = (xc.get(endx) - xc.get(startx)) * (yc.get(endy) - yc.get(starty));
         if (area < minArea) minArea = area;
         xc.set(xIndex, x); yc.set(yIndex, y);
      }
      pw.println(minArea);
      pw.close();

    }    
}
