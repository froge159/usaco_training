import java.util.*;
import java.io.*;

public class Main {
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
		n.sort(Comparator.comparingInt(n -> n.get(n).get(0)));
        pw.close();
    }
}
