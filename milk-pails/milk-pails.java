import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("pails.in")); 
        PrintWriter pw = new PrintWriter("pails.out");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        ArrayList<Integer> x_pours = new ArrayList<Integer>(Arrays.asList(0));
        ArrayList<Integer> y_pours = new ArrayList<Integer>(Arrays.asList(0));
        ArrayList<Integer> pours = new ArrayList<Integer>();

        if (x == 0 && y == 0) {
            pw.println(0);
            pw.close();
            System.exit(0);
        }

        for (int i = 0; i <= (z/x); i++) {
            for (int j = 0; j <= (z/y); j++) {
                if (x*i + y*j <= z) {
                    int total = x*i + y*j;
                    pours.add(total);
                }
            }
        }
        pw.println(Collections.max(pours));
        pw.close();
    }
}
