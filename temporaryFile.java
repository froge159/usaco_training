import java.util.*;
import java.io.*;

public class Air {
    static int findMin(ArrayList<Integer> inds, int[] diff) {
        int minval = Integer.MAX_VALUE;
        for (int i: inds) {
            if (Math.abs(diff[i]) < minval) minval = diff[i];
        }
        return minval;
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
        for (int i = 0; i < N; i++) { 
            start[i] = Integer.parseInt(st.nextToken());
            diff[i] = res[i] - start[i];
        }
        int count = 0;
        ArrayList<Integer> inds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (diff[i] != 0) {
                inds.add(i);
                int j = i + 1;
                while (true) {
                    if ((diff[j - 1] < 0 && diff[j] < 0) || (diff[j - 1] > 0 && diff[j] > 0)) {
                        inds.add(j);
                        j++;
                    }
                    else {
                        int min = findMin(inds, diff);
                        for (int k = inds.get(0); k <= inds.get(inds.size() - 1); k++) {
                            if (inds.get(0) < 0) {
                                start[k] += min;
                            }
                            else start[k] -= min;
                            diff[k] = res[k] - start[k];
                        }
                        count++;

                        int prev = diff[inds.get(0)];

                        for (int k = inds.get(1); k <= inds.get(inds.size() - 1); k++) {
                            if (diff[inds.get(k)] != prev) {
                                count++;
                                prev = diff[inds.get(k)];
                            }
                        }
                        inds.clear();
                        break;
                    }
                }
                i = j;
            }
        }
        pw.println(count);
        pw.close();
    }
}
