import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[] cows = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy", "Sue"};
    static ArrayList<String> permutations = new ArrayList<String>();
    static ArrayList<String> currList = new ArrayList<String>();
    static int[] indexCount = new int[8]; 
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter("lineup.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String[][] restrictions = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                String x = st.nextToken();
                if (j == 0) {restrictions[i][j] = x;}
                else if (j == 5) {restrictions[i][1] = x;}
            }
        }
        for (int i = 0; i < 8; i++) { indexCount[i]++; }
        perms(restrictions);
        Collections.sort(permutations);
        String[] words = permutations.get(0).split("\\s+");
        for (String word: words) {pw.println(word);}
        permutations.clear(); currList.clear();
        pw.close();


    }

    static void perms(String[][] r) {
        if (currList.size() == 8) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                int x = currList.indexOf(r[i][0]);
                int y = currList.indexOf(r[i][1]);
                switch (x) {
                    case 7:
                        if (!(currList.get(6) == currList.get(y))) {
                            ok = false;
                        }
                        break;
                    case 0:
                        if (!(currList.get(1) == currList.get(y))) {
                            ok = false;
                        }
                        break;
                    default:
                        if (!(currList.get(x + 1) == currList.get(y) || currList.get(x - 1) == currList.get(y))) {
                            ok = false;
                        }
                        break;
                }
            }
            if (ok == true) {permutations.add(String.join(" ", currList));}
            return;
        }
        else {
            for (int i = 0; i < 8; i++) {
                if (indexCount[i] <= 0) {continue;}
                indexCount[i]--;
                currList.add(cows[i]);
                perms(r);
                indexCount[i]++;
                currList.remove(currList.size() - 1);
            }
        }
    }
}
