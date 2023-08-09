// generates all subsets of an array with size less than a number. In this case it's 4.
public class sizedsubsets {
  public static void powerSet(int[] indexes, int index, ArrayList<Integer> curr) {
          int n = indexes.length;
   
          // base case
          if (index == n) {
              return;
          }
   
          // First print current subset
          if (curr.size() < 4 && curr.size() > 0) {System.out.println(curr.toString());}; 
   
          // Try appending remaining characters
          // to current subset
          for (int i = index + 1; i < n; i++) {
  			if (curr.size() < 3) {  // Modify this condition to allow subsets of size less than 4
  				curr.add(indexes[i]);
  				powerSet(indexes, i, curr);
  				curr.remove(curr.size() - 1);  // Backtrack by removing the last added element
  			}
  		}
  	}
  public static void main(String[] args) {
      int[] indexes = {1, 2, 3, 4};
      ArrayList<Integer> curr = new ArrayList<>();
      powerset(indexes, -1, curr);
  }
}
