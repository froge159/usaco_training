import java.util.*;
import java.io.*;

public class citiesAndStates {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
      PrintWriter pw = new PrintWriter("citystate.out");
      int n = Integer.parseInt(br.readLine());
      HashMap<String, Integer> x = new HashMap<>();
      int pairs = 0;
      for (int i = 0; i < n; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         String city = st.nextToken(); String state = st.nextToken();
         String combine = city.substring(0, 2) + state;
         if (!city.substring(0, 2).equals(state)) {
            if (!x.containsKey(combine)) {x.put(combine, 0);}
            x.put(combine, x.get(combine) + 1);
         }
      }
      for (String key: x.keySet()) {
         String flip = key.substring(2) + key.substring(0, 2);
         if (x.containsKey(flip)) {
            pairs += x.get(flip) * x.get(key);
         }
      }
      pw.println(pairs / 2);
      pw.close();
   }
}
