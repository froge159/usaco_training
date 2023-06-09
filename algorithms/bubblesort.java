import java.util.Arrays;

public class bubblesort {
   public static void main(String[] args) {
      int[] a = {3, 2, 1};
      int n = a.length;
     
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n - 1; j++) {
             // Swap adjacent elements if they are in decreasing order
            if (a[j] > a[j + 1]) {
               int temp = a[j];
               a[j] = a[j + 1]; a[j + 1] = temp;
            }
         }
     }
   }
}
