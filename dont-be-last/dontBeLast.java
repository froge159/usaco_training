import java.util.*;
import java.io.*;

public class dontBeLast {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
      PrintWriter pw = new PrintWriter("notlast.out");
      int n = Integer.parseInt(br.readLine());
      HashMap<String, Integer> cows = new HashMap<>();
      int count = 0;
      String line;
      while ((line = br.readLine()) != null) {
         count++;
         StringTokenizer st = new StringTokenizer(line);
         String cow = st.nextToken(); int milk = Integer.parseInt(st.nextToken());
         if (cows.containsKey(cow)) {
            int currentValue = cows.get(cow);
            int newValue = currentValue + milk;
            cows.put(cow, newValue);
         }
         else {cows.put(cow, milk);}
      }
      
      Set<String> keySet = cows.keySet(); ArrayList<String> cowList = new ArrayList<>(keySet);
      Collection<Integer> values = cows.values(); ArrayList<Integer> milkList = new ArrayList<>(values);
      for (int i = 0; i < cowList.size(); i++) {
         for (int j = 0; j < cowList.size() - 1; j++) {
            if (milkList.get(j) > milkList.get(j+1)) {
               Collections.swap(milkList, j, j+1); Collections.swap(cowList, j, j+1);
            }
         }
      }
      if (count < n) {
         if (Collections.frequency(milkList, milkList.get(0)) > 1) {pw.println("Tie");}
         else {pw.println(cowList.get(0));}
      }
      else if (count == 1) {pw.println(cowList.get(0));}
      
      else {
         int min = milkList.get(0);
         for (int i: milkList) {
            if (i != min) {
               if (Collections.frequency(milkList, i) > 1) {pw.println("Tie"); break;}
               else {pw.println(cowList.get(milkList.indexOf(i))); break;}
            }
         }
         if (Collections.frequency(milkList, min) == milkList.size()) {pw.println("Tie");}
      }
      
      pw.close();
   }
}
