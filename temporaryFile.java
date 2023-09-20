import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		int[][] ranges = new int[2][2];

		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			ranges[i][0] = Integer.parseInt(st.nextToken());
			ranges[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < K; i++) {
			int[] clone = new int[N + 1];
			for (int j = 1; j <= N; j++) {
				int index = j;
				int orig = j;
				if (ranges[0][0] <= j && j <= ranges[0][1]) {
					clone[ranges[0][0] + (ranges[0][1]-j)] = arr[j];
					index = ranges[0][0] + (ranges[0][1]-j);
				}
				if (ranges[1][0] <= index && index <= ranges[1][1]) {
					clone[ranges[1][0] + (ranges[1][1] - index)] = arr[orig];
				}
			}
			arr = clone;
		}
	}
}
