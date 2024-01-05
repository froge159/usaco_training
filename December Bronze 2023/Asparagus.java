import java.util.*;
import java.io.*;

public class Asparagus {
	static void solve(long[][] arr, PrintWriter pw) {
		// 0 - initial   1 - increase        2 - ordering
		if (arr.length == 1) pw.println(0);
		else {
			Arrays.sort(arr, (a, b) -> Long.compare(a[2], b[2]));
			double min = Double.MIN_VALUE * -1; double max = Double.MAX_VALUE;
            boolean flag = false; 
			for (int i = 0; i < arr.length - 1; i++) { 
				long m1 = arr[i][0]; long m2 = arr[i + 1][0];
				long inc1 = arr[i][1]; long inc2 = arr[i + 1][1];

                if (m1 <= m2 && inc1 == inc2) {
                    flag = true; break;
                }
				long left = inc1 - inc2;
				long right = m2 - m1;

				if (left < 0) max = Math.min(max, (double) right / left);
				else min = Math.max(min, (double) right / left);
                
			}
			//pw.println(min);
			if (min % 1 == 0) min++;
			else min = Math.ceil(min);
			if (max % 1 == 0) max--;
			else max = Math.floor(max);


			//pw.println(min);
			if (max < min || flag) pw.println(-1);
			else {
				if (min == Double.MIN_VALUE) pw.println(0);
				else pw.println((long) min);
			}
		}
	}
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new FileReader("input.in"));
        // PrintWriter pw = new PrintWriter("output.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			long[][] arr = new long[N][3];
			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			//pw.println(Arrays.deepToString(arr));
			solve(arr, pw);
		}
        pw.close();
    }
}
