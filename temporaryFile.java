import java.util.*;
import java.io.*;

public class temporaryFile {
   static int sum = Integer.MIN_VALUE;
   static void powerSet(int[] arr, int index, ArrayList<Integer> curr) {
      int n = arr.length;
      if (index == n) {return;}
      
      if (curr.size() > 0) {
         System.out.println(sum);
         int temp = 0;
         for (int i: curr) {temp += curr.get(i);}
         if (temp > sum) {sum = temp;}
      }
      
      for (int i = index + 1; i < n; i++) {
         curr.add(arr[i]);
         powerSet(arr, i, curr);
         curr.remove(curr.size() - 1);
      }
   }
   public static int sequence(int[] arr) {
      if (arr.length == 0) {return 0;}
      else {
         for (int i: arr) {
            if (i < 0) {return 0;}
         }
         ArrayList<Integer> curr = new ArrayList<>();
         powerSet(arr, -1, curr);
      }
      return sum; 
      
   }

   public static void main(String[] args) {
      int[] testArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
      System.out.println(sequence(testArr));
   }
}
