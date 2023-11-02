/* Obervations:
first set unmovable cows into respective positions
we can try putting 1 at every position and check if it satisfies the hierarchy

Solution:
create empty array of size N
fill array with unmovable cows
if 1 is an unmovable cow, return 1 index

for every position available to 1:
  loop through array again put cows in hierarchy in earliest possible positions. if it is already in array, let it be.
  loop through array again and check if it satisfies the hierarchy: return index of 1 */
import java.util.*;
import java.io.*;

public class Main {
    static int contains(int[] arr, int num) {
        Arrays.sort(arr);
        if (Arrays.binarySearch(arr, num) < 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N + 1];
        int[] order = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) order[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {pw.println(b); pw.close();}
            nums[b] = a;
        }
        for (int i = 1; i < N + 1; i++) {
            if (nums[i] == 0) {
                int[] clone = nums.clone();
                clone[i] = 1;
                for (int j = 0; j < M; j++) {
                    if (contains(clone, order[j])) 
                }
            }
        }
        pw.close();
    }
}
