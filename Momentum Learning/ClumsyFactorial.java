import java.util.*;
import java.io.*;

public class ClumsyFactorial {
   public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	PrintWriter pw = new PrintWriter(System.out);
      	StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		// * / + -
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int x = 0;
			for (int j = num; j >= num % 4; j -= 4) {
				if (j - 2 <= 0) {
					x += j * (j - 1);
				}
				else {
					if (j != num) x -= j * (j - 1) / (j - 2);
					else {x += j * (j - 1) / (j - 2);}
				}
			}
			if (num > 3) {
				for (int j = num - 3; j >= num % 4; j -= 4) {
					if (j - 2 < 0) {
						x += j;
					}
					else {
						x += j;
					}
				}
			}
			sum += x;
			//pw.println(x);
		}
		// 3 * 2 / 1
		pw.println(sum);
		pw.close();
   }
}
