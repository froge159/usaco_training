import java.util.*;
import java.io.*;

class MilkingOrder {
    static boolean contains(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return true;
        }
        return false;
    }
    static int indexOf(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
        PrintWriter pw = new PrintWriter("milkorder.out");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        int[] orig = new int[N + 1];
        int[] hier = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            hier[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < J; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            orig[b] = a;
        } 

        if (contains(orig, 1)) pw.println(indexOf(orig, 1));
        for (int i = 1; i <= N; i++) {
            int[] cows = orig.clone();
            if (cows[i] == 0) {
                cows[i] = 1;
                int prev = 0;
                for (int index = 0; index < K; index++) {
                    // pw.println(Arrays.toString(cows));
                    if (contains(cows, hier[index])) {
                        prev = indexOf(cows, hier[index]);
                        continue;
                    }
                    if (index == 0) {
                        for (int j = 1; j <= N; j++) {
                            if (cows[j] == 0) { 
                                cows[j] = hier[index];
                                prev = j;
                                break;
                            }
                        }
                    }
                    else {
                        for (int j = prev; j <= N; j++) {
                            if (cows[j] == 0) {
                                cows[j] = hier[index];
                                prev = j;
                                break;
                            }
                        }
                    }
                }
                int[] temp = new int[hier.length];
                int index = 0;
                for (int k: cows) {
                    if (contains(hier, k)) {
                        temp[index] = k;
                        index++;
                    }
                }
    
                // if (i == 22) pw.println(Arrays.toString(temp) + "\n" + Arrays.toString(hier));
                if (Arrays.equals(temp, hier)) {
                    pw.println(i);
                    break;
                }
            }
        }
        pw.close();
    }
}
