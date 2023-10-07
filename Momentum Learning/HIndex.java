import java.util.*;
import java.io.*;

class HIndex {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		//PrintWriter pw = new PrintWriter("swap.out");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		for (int i = N - 1; i >= 0; i--) {
			count++;
			if (arr[i] == count) {
				pw.println(count);
				break;
			}
		}
      	pw.close(); 
	}
}
