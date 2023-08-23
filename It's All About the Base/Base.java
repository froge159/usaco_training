import java.util.*;
import java.io.*;

public class Base {
    static int me(int aNum, int k, int j) {
        double x = Character.getNumericValue(String.valueOf(aNum).charAt(k)) * Math.pow(j, Math.abs(k-2));
        return (int) x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whatbase.in"));
        PrintWriter pw = new PrintWriter("whatbase.out");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            HashMap<Integer, Integer> a = new HashMap<>();
            HashMap<Integer, Integer> b = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int aNum = Integer.parseInt(st.nextToken()); 
            int bNum = Integer.parseInt(st.nextToken());
            for (int j = 10; j < 15001; j++) { // 2, 0    1, 1     0, 2
                int aSum = 0; int bSum = 0;
                aSum += me(aNum, 2, j) + me(aNum, 1, j) + me(aNum, 0, j);
                bSum += me(bNum, 2, j) + me(bNum, 1, j) + me(bNum, 0, j);
                a.put(aSum, j);
                b.put(bSum, j);
            }
            Set<Integer> setOne = a.keySet();
            Set<Integer> setTwo = b.keySet();
            setOne.retainAll(setTwo);
            Integer[] commonKeys = setOne.toArray(new Integer[1]);
            pw.println(a.get(commonKeys[0]) + " " + b.get(commonKeys[0]));
        }
        pw.close();

    }
}
