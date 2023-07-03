import java.util.*;
import java.io.*;

public class milkingOrder {
   private static boolean containsElement(int[] array, int element) {
    for (int value : array) {
        if (value == element) {
            return true;
        }
    }
    return false;
   }
   private static int findIndex(int[] array, int element) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == element) {
            return i;
        }
    }
    return -1;
}
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
      PrintWriter pw = new PrintWriter("milkorder.out");
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n  = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken()); 
      int k = Integer.parseInt(st.nextToken());
      int[] x = new int[m];
      int[] order = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
         x[i] = Integer.parseInt(st.nextToken());
      }
      for (int i = 0; i < k; i++) {
         st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         order[Integer.parseInt(st.nextToken()) - 1] = a;
      }
      if (containsElement(x, 1)) {
         for (int i = 0; i <= n - x.length; i++) {
            int[] clone = order.clone();
            int index = 0;
            for (int j = i; j < n; j++) {
               if (index >= m) {break;}
               else if (containsElement(x, clone[j])) {index++;}
               if (clone[j] == 0) { clone[j] = x[index]; index++; }
            } 
            ArrayList<Integer> indexes = new ArrayList<>();
            for (int l = 0; l < m; l++) {
               indexes.add(findIndex(clone, x[l]));
            }
            List<Integer> copy = new ArrayList<>(indexes); Collections.sort(copy);
            if (copy.equals(indexes)) {pw.println(findIndex(clone, 1) + 1); break;}
            copy.clear(); indexes.clear();
         }
      }



      else {
         for (int i = 0; i < n; i++) {
            int[] clone = order.clone();
            if (clone[i] == 0) {
               clone[i] = 1; 
               int index = 0;    
               for (int j = 0; j < n; j++) { 
                  if (index >= m) {break;}
                  else if (containsElement(clone, x[index])) {index++;}
                  if (clone[j] == 0) {
                     clone[j] = x[index]; index++;
                  }
               }
               ArrayList<Integer> indexes = new ArrayList<>();
               for (int l = 0; l < m; l++) {
                  indexes.add(findIndex(clone, x[l]));
               }
               List<Integer> copy = new ArrayList<>(indexes); Collections.sort(copy);
               if (copy.equals(indexes)) {pw.println(i + 1); break;}
               copy.clear(); indexes.clear();
            }
         }
      }
      pw.close();
   }
}
