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
            String line = st.nextToken();
            if (line.charAt(0) == 'E') {
                e.add(new ArrayList<Integer>());
                e.get(i).add(Integer.parseInt(line.substring(2, 3)));
                e.get(i).add(Integer.parseInt(line.substring(4)));
                e.get(i).add(i);
            }
            else {
                n.add(new ArrayList<Integer>());
                n.get(i).add(Integer.parseInt(line.substring(2, 3)));
                n.get(i).add(Integer.parseInt(line.substring(4)));
                n.get(i).add(i);
            }
        }
        pw.close();
    }
}
