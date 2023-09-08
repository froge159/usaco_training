import java.util.*;
import java.io.*;

public class Triangles {  
   public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
         PrintWriter pw = new PrintWriter("triangles.out");
         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
         // store points in 2d array, generate all perms, check if contains x or y parallel line.
         int N = Integer.parseInt(st.nextToken());
         double[][] arr = new double[N][2];
         for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
               arr[i][j] = Double.parseDouble(st.nextToken());
            }
         }
         double max_area = Double.MIN_VALUE;
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               for (int k = 0; k < N; k++) {
                  int xcount = 0;
                  int ycount = 0;
                  if (arr[i][1] == arr[j][1]) xcount++;
                  if (arr[i][0] == arr[j][0]) ycount++;
                  if (arr[j][1] == arr[k][1]) xcount++;
                  if (arr[j][0] == arr[k][0]) ycount++;
                  if (arr[i][1] == arr[k][1]) xcount++;
                  if (arr[i][0] == arr[k][0]) ycount++;

                  if (xcount + ycount > 1) {
                     double distOne = Math.sqrt(Math.pow(arr[j][0]-arr[i][0], 2) + Math.pow(arr[j][1]-arr[i][1], 2));
                     double distTwo =  Math.sqrt(Math.pow(arr[k][0]-arr[j][0], 2) + Math.pow(arr[k][1]-arr[j][1], 2));
                     double distTres =  Math.sqrt(Math.pow(arr[i][0]-arr[k][0], 2) + Math.pow(arr[i][1]-arr[k][1], 2));
                     double s = (distOne + distTwo + distTres) / 2;
                     double area = Math.sqrt(s * (s - distOne) * (s - distTwo) * (s - distTres));
                     if (area > max_area) {
                        max_area = area;
                     }
                  }
                  
               }
            }
         }
         pw.println(Math.round(max_area * 2));
         pw.close();
   }
}
