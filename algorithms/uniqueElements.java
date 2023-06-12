// find the number of unique elements of an array without using hashset
import java.util.*;

public class UniqueElementsExample {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 2, 3, 5, 6, 1, 4};
        
        Arrays.sort(array);
        
        int count = 0;
        int previous = Integer.MIN_VALUE;
        
        for (int element : array) {
            if (element != previous) {
                count++;
                previous = element;
            }
        }
        
        System.out.println("Number of unique elements: " + count);
    }
}
