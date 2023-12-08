import java.util.*;
import java.io.*;

public class myClass {
    static int findMin(ArrayList<Integer> inds, int[] diff) {
        int minval = Integer.MAX_VALUE;
        for (int i: inds) {
            if (Math.abs(diff[i]) < minval && Math.abs(diff[i]) != 0) minval = diff[i];
        }
        return (minval == Integer.MAX_VALUE) ? 0 : minval;
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] res = new int[N]; int[] start = new int[N]; int[] diff = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) res[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startIndex = 0;
        for (int i = 0; i < N; i++) { 
            start[i] = Integer.parseInt(st.nextToken());
            diff[i] = res[i] - start[i];
            if (diff[i] != 0 && startIndex == 0) startIndex = diff[i];
        }
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        ArrayList<Integer> temp =  new ArrayList<>();

        for (int i = startIndex; i < N; i++) {
            
        }
        int prev = 0;
        int count = 0;
        for (int i = 0; i < groups.size(); i++) {
            int min = findMin(groups.get(i), diff);

            for (int j = 0; j < groups.get(i).size(); j++) {
                int ind = groups.get(i).get(j);
                if (diff[ind] != 0) {
                    start[ind] += min; 
                    diff[ind] = res[ind] - start[ind];
                }
            }
            count += Math.abs(min);
            prev = Integer.MIN_VALUE; 
            for (int j = 0; j < groups.get(i).size(); j++) {
                int ind = groups.get(i).get(j);
                if (diff[ind] != prev || diff[ind] == 0) {
                    if (j != 0) count += Math.abs(diff[ind - 1]);
                }
                prev = diff[ind];
                if (j == groups.get(i).size() - 1) {
                    count += Math.abs(diff[ind]);
                }
            }
            pw.println(count + " " + groups.get(i).toString());
        }
        pw.println(count);
        pw.close();
    }
}
