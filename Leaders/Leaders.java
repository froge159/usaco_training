import java.util.*;
import java.io.*;
// http://usaco.org/index.php?page=viewproblem2&cpid=1275
public class Solve {
    static int toInt(char num) {
        return Character.getNumericValue(num);
    }
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        int N = Integer.parseInt(st.nextToken());
        boolean[] leader = new boolean[N + 1];
        char[] letters = new char[N];
        int earlyG = 0; int earlyH = 0;
        int[][] startEnd = new int[N][2];


        st = new StringTokenizer(br.readLine());
        String cows = st.nextToken();
        for (int i = 0; i < N; i++) {
            letters[i] = cows.charAt(i);
            startEnd[i][0] = i + 1;
            if (cows.charAt(i) == 'G' && earlyG == 0) { earlyG = i + 1; leader[earlyG] = true;}
            if (cows.charAt(i) == 'H' && earlyH == 0) { earlyH = i + 1; leader[earlyH] = true;}
        }

        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            startEnd[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = startEnd[earlyG - 1][1]; i < N; i++) {
            if (letters[i] == 'G') {
                leader[earlyG] = false;
                earlyG = 0;
                break;
            }
        } 
        for (int i = startEnd[earlyH - 1][1]; i < N; i++) {
            if (letters[i] == 'H') {
                //pw.println(i);
                leader[earlyH] = false;
                earlyH = 0;
                break;
            }
        }
        if (earlyH != 0 && earlyG != 0) { count++; }

        for (int i = 0; i < N; i++) {
            if (leader[i + 1]) continue;

            if (letters[i] == 'G') {
                if (earlyH == 0)   continue; 
                if (startEnd[i][1] >= earlyH && startEnd[i][0] <= earlyH)  {count++;  }
            }
            else if (letters[i] == 'H') {
                if (earlyG == 0) continue;
                if (startEnd[i][1] >= earlyG && startEnd[i][0] <= earlyG) { count++;}
            }
        }
        pw.println(count);
        pw.close();
    }
}
