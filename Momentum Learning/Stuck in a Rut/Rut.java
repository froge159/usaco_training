import java.util.*;
import java.io.*;

public class Rut {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("rut.in"));
        // PrintWriter pw = new PrintWriter("rut.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] dists = new int[N];
        boolean[] blocked = new boolean[N];
        ArrayList<ArrayList<Integer>> n = new ArrayList<>();
        ArrayList<ArrayList<Integer>> e = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("E")) {
                e.add(new ArrayList<Integer>());
                e.get(e.size() - 1).add(Integer.parseInt(st.nextToken()));
                e.get(e.size() - 1).add(Integer.parseInt(st.nextToken()));
                e.get(e.size() - 1).add(i);
            }
            else {
                n.add(new ArrayList<Integer>());
                n.get(n.size() - 1).add(Integer.parseInt(st.nextToken()));
                n.get(n.size() - 1).add(Integer.parseInt(st.nextToken()));
                n.get(n.size() - 1).add(i);
            }
        }
		Collections.sort(n, Comparator.comparing(a -> a.get(0)));
        Collections.sort(e, Comparator.comparing(a -> a.get(1)));
        Arrays.fill(dists, -1);

        for (int i = 0; i < n.size(); i++) {
            for (int j = 0; j < e.size(); j++) {
                if (n.get(i).get(0) > e.get(j).get(0) && !blocked[n.get(i).get(2)] && !blocked[e.get(j).get(2)] && e.get(j).get(1) > n.get(i).get(1)) {
                    if (e.get(j).get(1) - n.get(i).get(1) > n.get(i).get(0) - e.get(j).get(0)) {
                        dists[n.get(i).get(2)] = e.get(j).get(1) - n.get(i).get(1);
                        blocked[n.get(i).get(2)] = true;
                    }
                    if (n.get(i).get(0) - e.get(j).get(0) > e.get(j).get(1) - n.get(i).get(1)) {
                        dists[e.get(j).get(2)] = n.get(i).get(0) - e.get(j).get(0);
                        blocked[e.get(j).get(2)] = true;
                    }
                }
            }
        }
        for (int i: dists) pw.println((i == -1) ? "Infinity": i);
        // pw.println(e.toString());
        pw.close();
    }
}
