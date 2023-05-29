import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
// create array of values (speeding ticket)
//      do cows ranges and use cooling needs
//      then apply cooling of ac range and subtract cools from cows
//      if <=0 for all values
// store total in leasCost, replace if needed


public class Testing {
    static ArrayList<Integer> costs = new ArrayList<Integer>();
    static int[] cowsRow = new int[100];
    static int n, m;
    static int[][] cows = new int[n][];
    static int[][] ac = new int[m][];
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        cows = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new int[3];
            for (int j = 0; j < 3; j++) {
                cows[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ac = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            ac[i] = new int[4];
            for (int j = 0; j < 4; j++) {
                ac[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] array = new int[m];
        int index = -1;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            array[i] = i;
        }
        set(array, index, curr);
        pw.println(Collections.min(costs));
        Arrays.fill(array, 0);
        curr.clear();
        pw.close();
    } 

    static void set(int[] arr, int index, ArrayList<Integer> curr) { 
        for (int i = 0; i < n; i++) {
            for (int j = cows[i][0] - 1; j <= cows[i][1] - 1; j++) {
                cowsRow[j] = cows[i][2]; 
            }
        }   
        int x = arr.length;
        if (index == x) {
            return;
        } 


        int size = curr.size(); 
        if (size > 0) { 
            for (int i = 0; i < size; i++) {
                for (int k = ac[curr.get(i)][0] - 1; k <= ac[curr.get(i)][1] - 1; k++){
                    cowsRow[k] -= ac[curr.get(i)][2];
                }
            }
            
            ArrayList<Integer> list = Arrays.stream(cowsRow).boxed().collect(Collectors.toCollection(ArrayList::new));
            if (list.stream().allMatch(num -> num <= 0)) {
                int tempCost = 0;
                for (int i = 0; i < size; i++) { 
                    tempCost += ac[curr.get(i)][3];
                }
                costs.add(tempCost);
            }
            list.clear();
            Arrays.fill(cowsRow, 0);
        } 

        for (int i = index + 1; i < x; i++) {
            curr.add(arr[i]);
            set(arr, i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
