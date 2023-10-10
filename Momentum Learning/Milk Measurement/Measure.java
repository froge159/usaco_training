import java.util.*;
import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
      PrintWriter pw = new PrintWriter("measurement.out");
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      String[][] log = new String[101][2];
      HashMap<String, Integer> outputs = new HashMap<>();
      int count = 0;
      ArrayList<String> old = new ArrayList<>();
      ArrayList<String> newList = new ArrayList<>();
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         int index = Integer.parseInt(st.nextToken());
         String cow = st.nextToken();
         log[index][0] = cow; log[index][1] = st.nextToken();
         outputs.put(cow, 7);
         old.add(cow);
      }

      for (int i = 1; i <= 100; i++) {
         if (log[i][0] == null) continue;
         if (log[i][1].charAt(0) == '+') {
            outputs.put(log[i][0], outputs.get(log[i][0]) + Integer.parseInt(log[i][1].substring(1)));
         }
         else {
            outputs.put(log[i][0], outputs.get(log[i][0]) - Integer.parseInt(log[i][1].substring(1)));
         }
         int max = Integer.MIN_VALUE;
         for (int val: outputs.values()) {
            if (val > max) max = val;
         }
         for (Map.Entry<String,Integer> entry : outputs.entrySet()) {
            if (entry.getValue() == max) newList.add(entry.getKey());
         }
         if (!old.equals(newList)) count++;
         old.clear(); old.addAll(newList);
         newList.clear();
      }
      pw.println(count);
      pw.close();
   }
}
