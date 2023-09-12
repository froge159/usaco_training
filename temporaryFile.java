import java.io.*;
import java.util.*;

public class Solve {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[][] answer = new char[N][N];
			char[][] canvas = new char[N][N];
			char[][] stamp;
			int c = 0;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for (int z = 0; z < N; z++) {
					answer[c][z] = line.charAt(z);
				}
				c++;
			}
			c = 0;
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			stamp = new char[K][K];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				String line = st.nextToken();
				for (int z = 0; z < K; z++) {
					stamp[c][z] = line.charAt(z);
				}
				c++;
			}
			
			for (int rot = 0; rot < 4; rot++) {
				if (rot != 0) {
					char[][] clone = stamp.clone();
					for (int i = 0; i < K; i++) {
						for (int idk = 0; idk < K; i++) {
							for (int z = 0; z < K; z++) {
								for (int j = K; j > -1; j--) {
									stamp[i][idk] = clone[z][k];
								}
							}
						}
					}
				}
				for (int rows = 0; rows <= N - K; rows++) { // row index
					
					for (int cols = 0; cols <= N - K; cols++) { // index inside subarray
					}
				}
				
			}
		}
	}
}
