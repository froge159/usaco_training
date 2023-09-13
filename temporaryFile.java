import java.util.Scanner;

public class StampGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        
        for (int t = 0; t < T; t++) {
            scanner.nextLine(); // Read and discard the empty line
            
            int N = scanner.nextInt(); // Size of the grid
            scanner.nextLine(); // Move to the next line
            
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                grid[i] = line.toCharArray();
            }
            
            int K = scanner.nextInt(); // Size of the stamp
            scanner.nextLine(); // Move to the next line
            
            char[][] stamp = new char[K][K];
            for (int i = 0; i < K; i++) {
                String line = scanner.nextLine();
                stamp[i] = line.toCharArray();
            }
            
            char[][] ans = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans[i][j] = '.';
                }
            }
            
            for (int rot = 0; rot < 4; rot++) {
                for (int i = 0; i <= N - K; i++) {
                    for (int j = 0; j <= N - K; j++) {
                        boolean canStamp = true;
                        for (int a = 0; a < K; a++) {
                            for (int b = 0; b < K; b++) {
                                if (grid[i + a][j + b] == '*' && stamp[a][b] == '.') {
                                    canStamp = false;
                                    break;
                                }
                            }
                            if (!canStamp) {
                                break;
                            }
                        }
                        
                        if (canStamp) {
                            for (int a = 0; a < K; a++) {
                                for (int b = 0; b < K; b++) {
                                    if (stamp[a][b] == '*') {
                                        ans[i + a][j + b] = '*';
                                    }
                                }
                            }
                        }
                    }
                }
                
                // Rotate the stamp 90 degrees clockwise
                char[][] newStamp = new char[K][K];
                for (int a = 0; a < K; a++) {
                    for (int b = 0; b < K; b++) {
                        newStamp[a][b] = stamp[K - 1 - b][a];
                    }
                }
                stamp = newStamp;
            }
            
            boolean isEqual = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] != ans[i][j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual) {
                    break;
                }
            }
            
            System.out.println(isEqual ? "YES" : "NO");
        }
        
        scanner.close();
    }
}
