import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowsignal.out"));
        
        StringTokenizer mnk = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(mnk.nextToken());
        int n = Integer.parseInt(mnk.nextToken());
        int k = Integer.parseInt(mnk.nextToken());
        // loop through line
        // count number of X and .
        // multiply by k and print it out again
        for (int i = 0; i < m; i++) {
            mnk = new StringTokenizer(br.readLine());
            String line = mnk.nextToken();

            for (int y = 0; y < k; y++) {
                for (int j = 0; j < n; j++) {
                char c = line.charAt(j);

                    for (int x = 0; x < k; x++) {
                        pw.print(c);
                    }
                }
                pw.println();
            }
            //pw.println();
        }
        pw.close();
        


    } 
}
