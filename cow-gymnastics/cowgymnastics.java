import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in")); 
        PrintWriter pw = new PrintWriter("gymnastics.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int consistentPairs = 0;
        List<ArrayList<Integer>> listOfLists = new ArrayList<>();
    
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> newList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                newList.add(Integer.parseInt(st.nextToken()));
            }
            listOfLists.add(newList);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ArrayList<Boolean> consistent = new ArrayList<Boolean>();
                for (int a = 0; a <= listOfLists.size() - 1; a++) { 
                    int i_index = listOfLists.get(a).indexOf(i);
                    int j_index = listOfLists.get(a).indexOf(j);
                    if (i_index < j_index) {
                        consistent.add(true);
                    }
                    else {
                        consistent.add(false);
                    }
                }
                if (!(consistent.contains(false))) {
                    consistentPairs++;
                }
            }
        }
        pw.println(consistentPairs);
        pw.close();

    }
}
