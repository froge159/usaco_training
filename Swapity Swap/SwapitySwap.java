import java.util.*;
import java.io.*;

class SwapitySwap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		PrintWriter pw = new PrintWriter("swap.out");
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		int[][] ranges = new int[2][2];
		int count = 0;
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			ranges[i][0] = Integer.parseInt(st.nextToken());
			ranges[i][1] = Integer.parseInt(st.nextToken());
		}
        for (int i = 1; i <= N; i++) { 
         arr[i] = i;
        }
        int[] arrClone = arr.clone();
		for (int i = 0; i < K; i++) {
			count++;
			reverse(arr, ranges[0][0], ranges[0][1]);
			reverse(arr, ranges[1][0], ranges[1][1]);
			if (Arrays.equals(arr, arrClone)) break;
		}
		for (int i = 0; i < K % count; i++) {
			reverse(arr, ranges[0][0], ranges[0][1]);
			reverse(arr, ranges[1][0], ranges[1][1]);
		}
		for (int i: arr) {
			if (i == 0) continue;
			pw.println(i);
		}

      	pw.close();
	}
	static void reverse(int[] arr, int i1, int i2) {
		while (i1 < i2) {
			int temp = arr[i1];
			arr[i1] = arr[i2];
			arr[i2] = temp;
			i1++;
			i2--;
		}
	}
}
