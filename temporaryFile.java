// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;
// outer loop will be rotation
	// rotate by creating clone of current array
	// loop through row by row, move to right, if can't, move down one row, if can't move up one row.
// 2nd nested loop will be y values. max top left y value is (N - K) note that K can change per rotation
// 2nd nested loop will be x values. max top left x value is (N - K) note that K can change per rotation

// checking: loop through row by row and check with current stamp. If ink orientation is the same, stamp.
	// stamping: if stamp cell = ink, stamp. 
// white orientation doens't matter.
// check if equals expected 
public class Main {
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
				if (rot == 0) continue;
				char[][] clone = stamp.clone(); // 1,0   0,0   1,1         0,1
				for (int i = 0; i < K; i++) {
					for (int idk = 0; idk < k; i++) {
						for (int z = 0; z < K; z++) {
							for (int j = K; j > -1; j--) {
								stamp[i][idk] = clone[z][k];
							}
						}
					}
				}
				for (int subArr = 0; subArr)
			}
		}
	}
}
