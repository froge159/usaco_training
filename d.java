import java.util.*;
import java.io.*;

public class Solve {  
   static ArrayList<ArrayList<Character>> rows = new ArrayList<>();
   static ArrayList<ArrayList<Character>> cols = new ArrayList<>();
   static ArrayList<ArrayList<Character>> diags = new ArrayList<>(); // 0 is left, 1 is right
   static ArrayList<Character> singles = new ArrayList<>();
   static ArrayList<ArrayList<Character>> rep = new ArrayList<>();
   static void add(int rowsIndex, int leftDiagIndex, int rightDiagIndex, String s) {
      if (!rows.get(rowsIndex).contains(s.charAt(0))) rows.get(rowsIndex).add(s.charAt(0));
      if (!rows.get(rowsIndex).contains(s.charAt(1))) rows.get(rowsIndex).add(s.charAt(1));
      if (!rows.get(rowsIndex).contains(s.charAt(2))) rows.get(rowsIndex).add(s.charAt(2));
      if (!cols.get(0).contains(s.charAt(0))) cols.get(0).add(s.charAt(0));
      if (!cols.get(1).contains(s.charAt(1))) cols.get(1).add(s.charAt(1));
      if (!cols.get(2).contains(s.charAt(2))) cols.get(2).add(s.charAt(2));
      if (!diags.get(0).contains(s.charAt(leftDiagIndex))) diags.get(0).add(s.charAt(leftDiagIndex));
      if (!diags.get(1).contains(s.charAt(rightDiagIndex))) diags.get(1).add(s.charAt(rightDiagIndex));
   }
   static void check(ArrayList<ArrayList<Character>> arr) {
      for (int i = 0; i < arr.size(); i++) { // C, B
            if (arr.get(i).size() == 1) {
               if (singles.size() == 0) {
                  singles.add(arr.get(i).get(0));
               }
               else {
                  if (!singles.contains(arr.get(i).get(0))) {
                     singles.add(arr.get(i).get(0));
                  }
               }
            }
            else if (arr.get(i).size() == 2) {
               char valueOne = arr.get(i).get(0);
               char valueTwo = arr.get(i).get(1);
               if (rep.size() == 0) {
                  rep.add(new ArrayList<Character>());
                  rep.get(0).add(valueOne);
                  rep.get(0).add(valueTwo);
                  continue;
               }
               boolean found = false;
               for (int j = 0; j < rep.size(); j++) {
                  if (rep.get(j).contains(valueOne) && rep.get(j).contains(valueTwo)) {
                     found = true;
                     break;
                  }
               }
               if (!found) {
                  rep.add(new ArrayList<Character>());
                  rep.get(rep.size() - 1).add(valueOne);
                  rep.get(rep.size() - 1).add(valueTwo);
               }
            }
         }
   }
   public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
         PrintWriter pw = new PrintWriter("tttt.out");
         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //PrintWriter pw = new PrintWriter(System.out);
         // initialize arraylists
         for (int i = 0; i < 3; i++) {
            rows.add(new ArrayList<Character>());
            cols.add(new ArrayList<Character>());
            diags.add(new ArrayList<Character>());
         }
         // add to arraylists only if doesn't already contains (set)
         StringTokenizer st = new StringTokenizer(br.readLine());
         add(0, 0, 2, st.nextToken());
         st = new StringTokenizer(br.readLine());
         add(1, 1, 1, st.nextToken());
         st = new StringTokenizer(br.readLine());
         add(2, 2, 0, st.nextToken());

         check(rows);
         check(cols);
         check(diags);
         
         pw.println(singles.size());
         pw.println(rep.size());
         pw.close();
   }
}
