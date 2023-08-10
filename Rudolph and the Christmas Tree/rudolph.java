import java.io.*;
import java.util.*;

public class rudolph {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// branches, base l, branch h  						3 4 2
		// *(branches) integers (location of bases) 		1 4 5
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int branches = Integer.parseInt(st.nextToken());
			double baseL = Double.parseDouble(st.nextToken());
			double branchH = Double.parseDouble(st.nextToken());
			double branchloc = 0;
			double area = baseL * branchH / 2; 
			double hypo = Math.sqrt(Math.pow(baseL/2, 2) + Math.pow(branchH, 2)); 
			double corner = Math.toDegrees(Math.asin(branchH / hypo));   
			double nexth = 0;
			double total = area * branches;
			st = new StringTokenizer(br.readLine());
			branchloc = Double.parseDouble(st.nextToken());
			for (int j = 0; j < branches - 1; j++) {
				if (j == 0) {
					nexth = Double.parseDouble(st.nextToken());
				}
				else {
					branchloc = nexth;
					nexth = Double.parseDouble(st.nextToken());
				}
				if (branchloc + branchH > nexth) {
					double lega = branchloc + branchH - nexth;
					double legb = lega / Math.tan(Math.toRadians(corner));
					total -= (lega * (legb * 2)) / 2; 
				}
			}
			System.out.println(total);
		}
	}
}
