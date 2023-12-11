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
        locs.put("Bessie", "Ox");
        for (int i = 0; i < N; i++) {
            String line = br.readLine();    
            String[] lineArr = line.split(" ");
            String a = lineArr[0]; String b = lineArr[7];
            String dir = lineArr[3]; String year = lineArr[4];
            if (dir.equals("previous")) {
                int count = 0;
                for (int j = (locs.get(b).equals("Ox"))? 11 : indexOf(years, locs.get(b)) - 1; j >= 0; j--) {
                    count++;
                    if (years[j].equals(year)) break;
                    if (j == 0) j = 12;
                }
                dists.put(a, dists.get(b) - count);
            }
            else {
                int count = 0;
                for (int j = (locs.get(b).equals("Rat") ? 0 : indexOf(years, locs.get(b))) + 1; j < 12; j++) {
                    count++;
                    if (years[j].equals(year)) break;
                    if (j == 11) j = -1;
                }
                dists.put(a, dists.get(b) + count);
            }
            locs.put(a, year);
        }
        pw.println(Math.abs(dists.get("Elsie")));
        pw.close();
    }
}
