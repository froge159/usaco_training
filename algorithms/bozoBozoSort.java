import java.util.*;
import java.io.*;

class bozobozoSort {
    
    public static void main(String[] args) throws IOException {
        // will use bufferedreader to make it faster ;-;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Bozo-Bozo sort.");
        System.out.println("This sorting method randomizes the array until it is sorted, but");
        System.out.println("The random nums in the Array don't have to be unique.");
        System.out.println("This means an array such as [1, 2, 2] from the parent array [2, 1, 1] is a valid randomization.");
        System.out.println();
        System.out.print("Number of elements in Array: ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        System.out.print("Enter nums followed by space: ");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int[] clone = nums.clone();
        int[] clone2 = nums.clone();
        Arrays.sort(clone);
        
        while (!Arrays.equals(clone, nums)) {
            for (int j = 0; j < N; j++) {
               nums[j] = clone2[(int) (Math.random() * N)];
            }
            count++;
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("Finished. ");
        System.out.println(count + " randomizations.");
    }
}
