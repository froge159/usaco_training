import java.util.*;
import java.io.*;
public class Year {
    static int indexOf(String[] arr, String year) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(year)) return i;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int dist = 0;
        String[] years = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"
        };
        HashMap<String, Integer> dists = new HashMap<>();
        HashMap<String, String> locs = new HashMap<>();

        dists.put("Bessie", 0);
        for (int i = 0; i < N; i++) {
            String line = br.readLine();    
            String[] lineArr = line.split(" ");
            String a = lineArr[0]; String b = lineArr[7];
            String dir = lineArr[3]; String year = lineArr[4];
            if (dir.equals("previous")) {
                dists.put(a, dists.get(b) - (indexOf(years, locs.get(b)) + 1 + (11 - indexOf(years, year))));
            }
            else {
                dists.put(a, dists.get(b) + (11 - indexOf(years, locs.get(b)) + indexOf(years, year) + 1));
            }
            locs.put(a, year);
        }
        pw.println(Math.abs(dists.get("Elsie")));
        pw.close();
    }
}
