import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int factors = 0;
    static ArrayList<Integer> q = new ArrayList<Integer>();
    static ArrayList<Integer> p = new ArrayList<Integer>();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
        // j = p; i = q
        for (int i = a; i <= b; i++) { 
            for (int j = 1; j < i; j++) { 
                q.add(i);
                p.add(j);
            }
        }
        factor(0);
        pw.println(q.size() - factors);
        pw.close();

    }
    static void factor (int index) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if (index == q.size()) return;


        for (int i = 2; i <= q.get(index); i++) {
            if (q.get(index) % i == 0) x.add(i);
        }
        for (int i = 2; i <= p.get(index); i++) {
            if (p.get(index) % i == 0) y.add(i);
        }
    
        for (int i = 0; i < x.size(); i++ ) set1.add(x.get(i));
        for (int i = 0; i < y.size(); i++) set2.add(y.get(i));
        
        set1.retainAll(set2);
        if (set1.size() > 0) factors++;
        
        set1.clear(); set2.clear(); 
        x.clear(); y.clear();
        factor(index + 1);

    }
}
