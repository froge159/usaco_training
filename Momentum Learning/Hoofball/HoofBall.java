import java.util.*;
import java.io.*;

public class HoofBall {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        //PrintWriter pw = new PrintWriter("hoofball.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> right = new ArrayList<>();
        ArrayList<ArrayList<Integer>> left = new ArrayList<>();

        right.add(new ArrayList<Integer>());
        right.get(0).add(0); right.get(0).add(1);
        int prevDiff = nums[1] - nums[0];
        for (int i = 1; i < N - 1; i++) {
            if (nums[i + 1] - nums[i] < prevDiff || nums[i + 1] - nums[i] == prevDiff) {
                if (right.get(right.size() - 1).size() == 0) {
                    right.get(right.size() - 1).add(i);
                }
                right.get(right.size() - 1).add(i + 1);
            }
            else {
                if (right.get(right.size() - 1).size() > 0) right.add(new ArrayList<Integer>());
            }
            prevDiff = nums[i + 1] - nums[i];
        }
        left.add(new ArrayList<Integer>());
        left.get(0).add(N - 1); left.get(0).add(N - 2);
        prevDiff = nums[N - 1] - nums[N - 2];
        for (int i = N - 2; i > 0; i--) {
            if (nums[i] - nums[i - 1] < prevDiff || nums[i] - nums[i - 1] == prevDiff) {
                if (left.get(left.size() - 1).size() == 0) {
                    left.get(left.size() - 1).add(i);
                }
                left.get(left.size() - 1).add(i - 1);
            }
            else {
                if (left.get(left.size() - 1).size() > 0) left.add(new ArrayList<Integer>());
            }
            prevDiff = nums[i] - nums[i - 1];
        }
        int a = (left.get(left.size() - 1).size() == 0) ? left.size() - 1 : left.size();
        int b = (right.get(right.size() - 1).size() == 0) ? right.size() - 1 : right.size();
        int count = a + b; 
        for (ArrayList<Integer> l: left) {
            for (ArrayList<Integer> r: right) {
                if (l.size() == 0 || r.size() == 0) continue;
                boolean found = true;
                Collections.sort(l); Collections.sort(r);
                if (l.size() == r.size() && !l.equals(r)) found = false;
                else if (l.size() < r.size()) {
                    for (int i: l) {
                        if (!r.contains(i)) {found = false; break;}
                    }
                }
                else if (r.size() < l.size()) {
                    for (int i: r) {
                        if (!l.contains(i)) {found = false; break;}
                    }
                }
                if (found) {count--; }
            }
        }
        pw.println(count);
        pw.close();
    }  
}
